package com.obric.memorydata.awareness.audio;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.keva.KevaImpl;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioError;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioQueryResult;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioSegment;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioSource;
import com.obric.memorydata.database.dao.AuditoryAsrTaskDao;
import com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao;
import com.obric.memorydata.database.entity.AuditoryAsrTaskEntity;
import com.obric.memorydata.database.entity.AuditorySyncStateEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.SpeakerEmbeddingPendingEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI;
import com.obric.memorydata.middleware.api.logging.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0081\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0018\u0002\n\u0003\b\u0092\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0012Á\u0002Â\u0002Ã\u0002Ä\u0002Å\u0002Æ\u0002Ç\u0002È\u0002É\u0002B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J]\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0000¢\u0006\u0002\b\u0019J\u001d\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0016J(\u0010#\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001bH\u0016J0\u0010*\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010+\u001a\u00020\u0012H\u0002J!\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020-0\u000eH\u0000¢\u0006\u0002\b.J1\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u000e2\f\u00100\u001a\b\u0012\u0004\u0012\u00020-0\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0002\b1J \u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u001bH\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u001dH\u0016J\u0016\u00108\u001a\u00020%2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000eH\u0002J\u0018\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001dH\u0016J:\u0010>\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001b2\b\u0010A\u001a\u0004\u0018\u00010\u001b2\u0006\u0010B\u001a\u00020\u001dH\u0016J8\u0010C\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u001dH\u0016J8\u0010F\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u001dH\u0016J\u0010\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u001bH\u0016J \u0010K\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u001dH\u0016J\"\u0010M\u001a\u0004\u0018\u00010\n2\u0006\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u001dH\u0002J\u0018\u0010N\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\u001dH\u0016J;\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020:2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u000e2\u0006\u0010L\u001a\u00020\u001dH\u0000¢\u0006\u0002\bUJ\u0018\u0010V\u001a\u00020P2\u0006\u0010Q\u001a\u00020:2\u0006\u0010W\u001a\u00020%H\u0002J\u0018\u0010X\u001a\u00020P2\u0006\u0010Q\u001a\u00020:2\u0006\u0010W\u001a\u00020%H\u0002J&\u0010Y\u001a\u00020P2\u0006\u0010Q\u001a\u00020:2\u0006\u0010W\u001a\u00020%2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u000eH\u0002J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010[\u001a\u00020\u001bH\u0002J \u0010\\\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020\u001bH\u0016J,\u0010^\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u001b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u000eH\u0002J\u0010\u0010_\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u001bH\u0016J\u0010\u0010b\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010c\u001a\u00020:2\u0006\u0010d\u001a\u00020\nH\u0002J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020T0\u000e2\u0006\u0010f\u001a\u00020gH\u0002J&\u0010h\u001a\u00020%2\u0006\u0010d\u001a\u00020\n2\u0006\u0010f\u001a\u00020g2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000eH\u0002J\u0010\u0010i\u001a\u00020\n2\u0006\u0010d\u001a\u00020\nH\u0002JN\u0010j\u001a\u00020k2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010l\u001a\u00020g2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\u00160\u00142\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0002J\u0018\u0010n\u001a\u00020o2\u0006\u0010l\u001a\u00020g2\u0006\u0010\u0010\u001a\u00020\fH\u0002J \u0010p\u001a\u00020\u00162\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\f2\u0006\u0010s\u001a\u00020\u001dH\u0002J\u0018\u0010t\u001a\u00020\u00162\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\fH\u0002J4\u0010u\u001a\u00020k2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010l\u001a\u00020g2\u0006\u0010v\u001a\u00020o2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J2\u0010w\u001a\u00020x2\u0006\u0010l\u001a\u00020g2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0018\u0010z\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u001b2\u0006\u0010{\u001a\u00020mH\u0002J \u0010|\u001a\u00020g2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010l\u001a\u00020g2\u0006\u0010}\u001a\u00020xH\u0002J\u0011\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0002J\u001d\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001dH\u0002J\u001a\u0010\u0086\u0001\u001a\u00020\u00162\u0006\u0010q\u001a\u00020\u007f2\u0007\u0010\u000b\u001a\u00030\u0087\u0001H\u0002J%\u0010\u0088\u0001\u001a\u00020\u00162\u0007\u0010\u000b\u001a\u00030\u0087\u00012\b\u0010\u0089\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u001dH\u0002J\u001b\u0010\u008b\u0001\u001a\u00020\u00162\u0007\u0010\u000b\u001a\u00030\u0087\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u001dH\u0002J5\u0010\u008c\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001b0\u008d\u00010\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020-0\u000e2\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0012H\u0002J7\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u001b2\u0007\u0010\u0092\u0001\u001a\u00020\u001d2\u0007\u0010\u0093\u0001\u001a\u00020\u001d2\u0007\u0010\u0094\u0001\u001a\u00020\u001d2\u0007\u0010\u0095\u0001\u001a\u00020\u001dH\u0002J\u0019\u0010\u0096\u0001\u001a\u00020\u00162\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001H\u0002J\u0011\u0010\u0099\u0001\u001a\u00020\f2\u0006\u00103\u001a\u00020\u001bH\u0002J\t\u0010\u009a\u0001\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001bH\u0002J\u0011\u0010\u009b\u0001\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001bH\u0002J\t\u0010\u009c\u0001\u001a\u00020\fH\u0002J\u0011\u0010\u009d\u0001\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u001bH\u0002J!\u0010\u009e\u0001\u001a\u00020%2\u0006\u00107\u001a\u00020\u001d2\u000e\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001H\u0002J\u0012\u0010 \u0001\u001a\u00020\u00122\u0007\u0010¡\u0001\u001a\u00020\fH\u0002J\u0011\u0010¢\u0001\u001a\u00020\u001b2\u0006\u0010q\u001a\u00020\fH\u0002J\u001b\u0010£\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0011\u0010¦\u0001\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001bH\u0002J\u0012\u0010§\u0001\u001a\u00020\u001b2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0002J\u0012\u0010§\u0001\u001a\u00020\u001b2\u0007\u0010¨\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010©\u0001\u001a\u00020\u001b2\u0007\u0010ª\u0001\u001a\u00020\u001bH\u0002J\u000e\u0010«\u0001\u001a\u00020\u001b*\u00030\u0084\u0001H\u0002J\u000e\u0010¬\u0001\u001a\u00020%*\u00030\u0084\u0001H\u0002J\u000e\u0010\u00ad\u0001\u001a\u00020\u001d*\u00030\u0084\u0001H\u0002J\u0017\u0010®\u0001\u001a\u00020\u0016*\u00030\u0087\u00012\u0007\u0010¨\u0001\u001a\u00020%H\u0002J\u0017\u0010¯\u0001\u001a\u00020\u0016*\u00030\u0087\u00012\u0007\u0010¨\u0001\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010±\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010²\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010³\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010´\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010µ\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010·\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¸\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¹\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010»\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¼\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010½\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¾\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¿\u0001\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010À\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Á\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Â\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ã\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ä\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Å\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Æ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ç\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010È\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010É\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ê\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ì\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Í\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ñ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ò\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ó\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ô\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Õ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ö\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010×\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ø\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ù\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ú\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Û\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ü\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Ý\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010Þ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ß\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010à\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010á\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010â\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ã\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ä\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010å\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010æ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ç\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010è\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010é\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ê\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ë\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ì\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010í\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010î\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ï\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ð\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ñ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ò\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ó\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ô\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010õ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ö\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010÷\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ø\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ù\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ú\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010û\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ü\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ý\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010þ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ÿ\u0001\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010 \u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010£\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010§\u0002\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010©\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010«\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¬\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010®\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010°\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010±\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010²\u0002\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010³\u0002\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010´\u0002\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010µ\u0002\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0002\u001a\u00020%X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010·\u0002\u001a\u00030¸\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010¹\u0002\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010º\u0002\u001a\u00030¸\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010»\u0002\u001a\u00030¼\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010½\u0002\u001a\"\u0012\u0004\u0012\u00020\u001b\u0012\u0005\u0012\u00030\u0090\u00010¾\u0002j\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0005\u0012\u00030\u0090\u0001`¿\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010À\u0002\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ê\u0002"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IAuditoryBridgeAPI;", "<init>", "()V", "hotwordsCache", "Lcom/obric/memorydata/awareness/audio/AuditoryHotwordsCache;", "getInst", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "mergePcmWavForTest", "Lorg/json/JSONObject;", "output", "Ljava/io/File;", AuditoryBridgeAPIImpl.KEY_SEGMENTS, "", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$TestWavSegment;", "privateSourceDirectory", "retainSources", "", "onDurationAdjusted", "Lkotlin/Function1;", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$TestWavDurationAdjustment;", "", "afterCopy", "Lkotlin/Function0;", "mergePcmWavForTest$awareness_obricRelease", "formatTimeForTest", "", "timestampMs", "", "timezoneId", "formatTimeForTest$awareness_obricRelease", "queryRecordData", "startTimestampSeconds", "endTimestampSeconds", "queryRecordDataPage", TypedValues.CycleType.S_WAVE_OFFSET, "", "limit", "queryHotwords", "accountScope", "getCachedHotwords", "queryRecordDataInternal", "paged", "selectLatestQuerySegments", "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioSegment;", "selectLatestQuerySegments$awareness_obricRelease", "selectLatestQuerySegmentPage", "selectedSegments", "selectLatestQuerySegmentPage$awareness_obricRelease", "prepareUploadWav", "taskId", "manifestJson", "deleteUploadBundle", "cleanupUploadBundles", "olderThanMs", "cleanupExpiredTerminalTasks", "tasks", "Lcom/obric/memorydata/database/entity/AuditoryAsrTaskEntity;", "persistTaskAndCursor", "taskJson", "expectedLastFileEndMs", "transitionTask", "expectedStatus", "targetStatus", "tosKey", "updatedAt", "markTaskRetry", "retryCount", "errorCode", "finishTask", "terminalStatus", "terminalAt", "recordTaskRequestEvent", "eventJson", "finalizeTaskTelemetry", "nowMs", "finalizeTaskTelemetryTransaction", "finalizePendingTaskTelemetry", "terminalDecision", "Lcom/obric/memorydata/awareness/audio/AuditoryTelemetryTrace$TerminalDecision;", "task", "rawIds", "raws", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "terminalDecision$awareness_obricRelease", "expiredDecision", "rawCount", "failedDecision", "completedL1Decision", "decodeLongArray", "raw", "commitL0Result", "resultJson", "logCommittedRawSpans", "countTasks", "removeScheduledTask", "taskRequestId", "clearAccountData", "decodeTask", "body", "decodeRawRows", "values", "Lorg/json/JSONArray;", "insertEmbeddings", "decodeValidationWarnings", "preparePrivateWav", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$PreparedWav;", "items", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavDurationAdjustment;", "copyGrantedSourcesToPrivate", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$PrivateSourceBatch;", "copyFileAtomically", AILabCheckPermissionTask.KEY_SOURCE, "destination", "expectedBytes", "moveAtomically", "mergePcmWav", "privateSources", "buildWavMergePlan", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavMergePlan;", "privateFiles", "reportWavDurationAdjustment", "adjustment", "writeMergedWav", "plan", "parsePcmWav", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavSource;", "file", "readPcmFormat", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;", "input", "Ljava/io/RandomAccessFile;", "size", "copyWavData", "Ljava/io/BufferedOutputStream;", "writeWavHeader", "format", "dataSize", "writeZeros", "grantSegments", "Lkotlin/Pair;", "reset", "resolveSegmentGrant", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$SegmentGrant;", "token", "startMs", "endMs", "durationMs", "readyAtMs", "revokeSegmentGrants", "tokens", "", "uploadWavFile", "uploadWavDirectory", "accountPrivateSourceDirectory", "privateSourceRootDirectory", "deletePrivateSourceDirectories", "cleanupPrivateSourceDirectories", "referencedTaskIds", "deleteDirectory", "directory", "safeSourceFileName", "formatTime", Api.KEY_TIMEZONE, "Ljava/util/TimeZone;", "isCurrentAccountAllowed", "sha256", EventBody.KEY_VALUE, "errorResponse", "error", "readFourCc", "readUInt16Le", "readUInt32Le", "writeUInt16Le", "writeUInt32Le", "CODE_SUCCESS", "CODE_ERROR", "PCM_FORMAT", "WAV_HEADER_SIZE", "SILENCE_SECONDS", "SPEAKER_VECTOR_DIMENSION", "MAX_TOTAL_BYTES", "MAX_SEGMENT_COUNT", "MAX_SEGMENT_GRANT_COUNT", "MAX_QUERY_PAGE_SIZE", "MAX_ERROR_CODE_LENGTH", "MAX_LOG_ID_LENGTH", "MAX_CLEANUP_TASKS", "MAX_TELEMETRY_RECOVERY_TASKS", "RAW_SPANS_PER_LOG", "MAX_RAW_SPAN_DEBUG_LOGS", "MAX_DURATION_DRIFT_MS", "TASK_RETENTION_MS", "INVALID_TIME_MS", "EMPTY_JSON_ARRAY", "WARNING_WAV_DURATION_ADJUSTED", "UPLOAD_DIRECTORY", "PRIVATE_SOURCE_DIRECTORY", "WAV_SUFFIX", "SOURCE_AUDITORY", "TASK_STATUS_PENDING_UPLOAD", "TASK_STATUS_PENDING_SUBMIT", "TASK_STATUS_WAITING_RESULT", "TASK_STATUS_DONE", "TASK_STATUS_FAILED", "ACTIVE_TASK_STATUSES", "TERMINAL_TASK_STATUSES", "RAW_TERMINAL_STATES", "ERROR_INVALID_TASK_ID", "ERROR_PREPARE_WAV_FAILED", "ERROR_SEGMENT_GRANT_INVALID", "ERROR_RESULT_INVALID", "ERROR_TASK_NOT_FOUND", "ERROR_COMMIT_FAILED", "ERROR_ACCOUNT_GATE_CLOSED", "ERROR_QUERY_PAGE_INVALID", "ERROR_ACCOUNT_LIFECYCLE_STOPPED", "ERROR_TELEMETRY_FINALIZE_FAILED", "ERROR_CODE_NONE", "ERROR_CODE_L1_FAILED", "ERROR_CODE_TASK_EXPIRED", "EVIDENCE_COMPLETE", "EVIDENCE_PARTIAL_IO", "EVIDENCE_PARTIAL_LOW_STORAGE", "KEY_CODE", "KEY_ERROR", "KEY_SEGMENTS", "KEY_HAS_MORE", "KEY_NEXT_OFFSET", "KEY_SEGMENT_TOKEN", "KEY_START_MS", "KEY_END_MS", "KEY_DURATION_MS", "KEY_READY_AT_MS", "KEY_AUDIO_REF", "KEY_AUDIO_SHA256", "KEY_MANIFEST", "KEY_TIMING", "KEY_COPY_STARTED_AT_MS", "KEY_COPY_FINISHED_AT_MS", "KEY_MERGE_FINISHED_AT_MS", "KEY_TASK_ID", "KEY_ACCOUNT_SCOPE", "KEY_STATUS", "KEY_AUDIO_PATH", "KEY_CREATED_AT", "KEY_UPDATED_AT", "KEY_LAST_FILE_END_MS", "KEY_LAST_QUERY_END_MS", "KEY_RAW_ROWS", "KEY_EMBEDDINGS", "KEY_DEVICE_ID", "KEY_TIMESTAMP", "KEY_SPAN_START", "KEY_SPAN_END", "KEY_PAYLOAD", "KEY_META", "KEY_STATE", "KEY_EMBEDDING_ID", "KEY_SESSION_ID", "KEY_LOCAL_SPEAKER_ID", "KEY_MODEL_VERSION", "KEY_VECTORS", "KEY_RAW_INDEXES", "KEY_COMMITTED_AT", "KEY_RAW_COUNT", "KEY_EMBEDDING_COUNT", "KEY_OBSERVATION_ID", "KEY_RAW_OBSERVATION_IDS", "KEY_REQUEST_LOG_IDS", "KEY_REQUEST_STAGE", "KEY_LOG_ID", "KEY_TRACE_VERSION", "KEY_TRACE_RESULT", "KEY_TRACE_START_AT_MS", "KEY_TRACE_END_AT_MS", "KEY_TRACE_COST_MS", "KEY_TRACE_TIME_VALID", "KEY_TRACE_ATTEMPT", "KEY_TRACE_ERROR_CODE", "KEY_TRACE_DETAILS", "KEY_SHOULD_REPORT", "KEY_EVENT_PAYLOAD", "KEY_EVENTS", "KEY_VALIDATION_WARNINGS", "KEY_WARNING_COUNTS", "KEY_SOURCE_START_MS", "KEY_SOURCE_END_MS", "KEY_AUDIO_START_MS", "KEY_AUDIO_END_MS", "KEY_VERSION", "KEY_SAMPLE_RATE", "KEY_CHANNELS", "KEY_BITS_PER_SAMPLE", "TRACE_VERSION", "TRACE_STAGE_TASK_PERSIST", "TRACE_STAGE_ASR_SUBMIT", "TRACE_STAGE_ASR_QUERY", "TRACE_STAGE_L0_COMMIT", "TRACE_RESULT_SUCCESS", "TRACE_RESULT_SUCCESS_L1", "TRACE_RESULT_SUCCESS_NO_L1", "TRACE_RESULT_SUCCESS_NO_ASR", "TRACE_RESULT_FAILED", "TRACE_RESULT_EXPIRED", "RESULT_CODE_L1", "RESULT_CODE_NO_L1", "RESULT_CODE_NO_ASR", "RESULT_CODE_FAILED", "RESULT_CODE_EXPIRED", "L0_VALIDATION_WARNING_CODE_REGEX", "Lkotlin/text/Regex;", "TIME_FORMAT", "TASK_ID_REGEX", "segmentGrantLock", "", "segmentGrants", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "segmentGrantSalt", "TestWavSegment", "TestWavDurationAdjustment", "SegmentGrant", "WavFormat", "WavSource", "WavDurationAdjustment", "PrivateSourceBatch", "WavMergePlan", "PreparedWav", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuditoryBridgeAPIImpl implements IAuditoryBridgeAPI {
    private static final Set<String> ACTIVE_TASK_STATUSES = null;
    private static final int CODE_ERROR = -1;
    private static final int CODE_SUCCESS = 0;
    private static final String EMPTY_JSON_ARRAY = "[]";
    private static final String ERROR_ACCOUNT_GATE_CLOSED = "ACCOUNT_GATE_CLOSED";
    private static final String ERROR_ACCOUNT_LIFECYCLE_STOPPED = "ACCOUNT_LIFECYCLE_STOPPED";
    private static final String ERROR_CODE_L1_FAILED = "L1_FAILED";
    private static final String ERROR_CODE_NONE = "NONE";
    private static final String ERROR_CODE_TASK_EXPIRED = "TASK_EXPIRED";
    private static final String ERROR_COMMIT_FAILED = "COMMIT_FAILED";
    private static final String ERROR_INVALID_TASK_ID = "INVALID_TASK_ID";
    private static final String ERROR_PREPARE_WAV_FAILED = "PREPARE_WAV_FAILED";
    private static final String ERROR_QUERY_PAGE_INVALID = "QUERY_PAGE_INVALID";
    private static final String ERROR_RESULT_INVALID = "RESULT_INVALID";
    private static final String ERROR_SEGMENT_GRANT_INVALID = "SEGMENT_GRANT_INVALID";
    private static final String ERROR_TASK_NOT_FOUND = "TASK_NOT_FOUND";
    private static final String ERROR_TELEMETRY_FINALIZE_FAILED = "TELEMETRY_FINALIZE_FAILED";
    private static final String EVIDENCE_COMPLETE = "COMPLETE";
    private static final String EVIDENCE_PARTIAL_IO = "PARTIAL_IO";
    private static final String EVIDENCE_PARTIAL_LOW_STORAGE = "PARTIAL_LOW_STORAGE";
    public static final AuditoryBridgeAPIImpl INSTANCE = null;
    private static final long INVALID_TIME_MS = -1;
    private static final String KEY_ACCOUNT_SCOPE = "account_scope";
    private static final String KEY_AUDIO_END_MS = "audio_end_ms";
    private static final String KEY_AUDIO_PATH = "audio_path";
    private static final String KEY_AUDIO_REF = "audio_ref";
    private static final String KEY_AUDIO_SHA256 = "audio_sha256";
    private static final String KEY_AUDIO_START_MS = "audio_start_ms";
    private static final String KEY_BITS_PER_SAMPLE = "bits_per_sample";
    private static final String KEY_CHANNELS = "channels";
    private static final String KEY_CODE = "code";
    private static final String KEY_COMMITTED_AT = "committed_at";
    private static final String KEY_COPY_FINISHED_AT_MS = "copy_finished_at_ms";
    private static final String KEY_COPY_STARTED_AT_MS = "copy_started_at_ms";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_DURATION_MS = "duration_ms";
    private static final String KEY_EMBEDDINGS = "embeddings";
    private static final String KEY_EMBEDDING_COUNT = "embedding_count";
    private static final String KEY_EMBEDDING_ID = "embedding_id";
    private static final String KEY_END_MS = "end_ms";
    private static final String KEY_ERROR = "error";
    private static final String KEY_EVENTS = "events";
    private static final String KEY_EVENT_PAYLOAD = "event_payload";
    private static final String KEY_HAS_MORE = "has_more";
    private static final String KEY_LAST_FILE_END_MS = "last_file_end_ms";
    private static final String KEY_LAST_QUERY_END_MS = "last_query_end_ms";
    private static final String KEY_LOCAL_SPEAKER_ID = "local_speaker_id";
    private static final String KEY_LOG_ID = "log_id";
    private static final String KEY_MANIFEST = "manifest";
    private static final String KEY_MERGE_FINISHED_AT_MS = "merge_finished_at_ms";
    private static final String KEY_META = "meta";
    private static final String KEY_MODEL_VERSION = "model_version";
    private static final String KEY_NEXT_OFFSET = "next_offset";
    private static final String KEY_OBSERVATION_ID = "observation_id";
    private static final String KEY_PAYLOAD = "payload";
    private static final String KEY_RAW_COUNT = "raw_count";
    private static final String KEY_RAW_INDEXES = "raw_indexes";
    private static final String KEY_RAW_OBSERVATION_IDS = "raw_observation_ids";
    private static final String KEY_RAW_ROWS = "raw_rows";
    private static final String KEY_READY_AT_MS = "ready_at_ms";
    private static final String KEY_REQUEST_LOG_IDS = "request_log_ids";
    private static final String KEY_REQUEST_STAGE = "stage";
    private static final String KEY_SAMPLE_RATE = "sample_rate";
    private static final String KEY_SEGMENTS = "segments";
    private static final String KEY_SEGMENT_TOKEN = "segment_token";
    private static final String KEY_SESSION_ID = "session_id";
    private static final String KEY_SHOULD_REPORT = "should_report";
    private static final String KEY_SOURCE_END_MS = "source_end_ms";
    private static final String KEY_SOURCE_START_MS = "source_start_ms";
    private static final String KEY_SPAN_END = "span_end";
    private static final String KEY_SPAN_START = "span_start";
    private static final String KEY_START_MS = "start_ms";
    private static final String KEY_STATE = "state";
    private static final String KEY_STATUS = "status";
    private static final String KEY_TASK_ID = "task_id";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_TIMING = "timing";
    private static final String KEY_TRACE_ATTEMPT = "attempt";
    private static final String KEY_TRACE_COST_MS = "cost_ms";
    private static final String KEY_TRACE_DETAILS = "details";
    private static final String KEY_TRACE_END_AT_MS = "end_at_ms";
    private static final String KEY_TRACE_ERROR_CODE = "error_code";
    private static final String KEY_TRACE_RESULT = "result";
    private static final String KEY_TRACE_START_AT_MS = "start_at_ms";
    private static final String KEY_TRACE_TIME_VALID = "time_valid";
    private static final String KEY_TRACE_VERSION = "v";
    private static final String KEY_UPDATED_AT = "updated_at";
    private static final String KEY_VALIDATION_WARNINGS = "validation_warnings";
    private static final String KEY_VECTORS = "vectors";
    private static final String KEY_VERSION = "version";
    private static final String KEY_WARNING_COUNTS = "warning_counts";
    private static final Regex L0_VALIDATION_WARNING_CODE_REGEX = null;
    private static final int MAX_CLEANUP_TASKS = 50;
    private static final long MAX_DURATION_DRIFT_MS = 1;
    private static final int MAX_ERROR_CODE_LENGTH = 80;
    private static final int MAX_LOG_ID_LENGTH = 200;
    private static final int MAX_QUERY_PAGE_SIZE = 1000;
    private static final int MAX_RAW_SPAN_DEBUG_LOGS = 4;
    private static final int MAX_SEGMENT_COUNT = 100;
    private static final int MAX_SEGMENT_GRANT_COUNT = 10000;
    private static final int MAX_TELEMETRY_RECOVERY_TASKS = 50;
    private static final long MAX_TOTAL_BYTES = 268435456;
    private static final int PCM_FORMAT = 1;
    private static final String PRIVATE_SOURCE_DIRECTORY = "auditory_memory_source";
    private static final int RAW_SPANS_PER_LOG = 4;
    private static final Set<String> RAW_TERMINAL_STATES = null;
    private static final int RESULT_CODE_EXPIRED = 101;
    private static final int RESULT_CODE_FAILED = 100;
    private static final int RESULT_CODE_L1 = 0;
    private static final int RESULT_CODE_NO_ASR = 2;
    private static final int RESULT_CODE_NO_L1 = 1;
    private static final long SILENCE_SECONDS = 3;
    private static final String SOURCE_AUDITORY = "auditory";
    private static final int SPEAKER_VECTOR_DIMENSION = 256;
    private static final Regex TASK_ID_REGEX = null;
    private static final long TASK_RETENTION_MS = 259200000;
    private static final String TASK_STATUS_DONE = "DONE";
    private static final String TASK_STATUS_FAILED = "FAILED";
    private static final String TASK_STATUS_PENDING_SUBMIT = "PENDING_SUBMIT";
    private static final String TASK_STATUS_PENDING_UPLOAD = "PENDING_UPLOAD";
    private static final String TASK_STATUS_WAITING_RESULT = "WAITING_RESULT";
    private static final Set<String> TERMINAL_TASK_STATUSES = null;
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String TRACE_RESULT_EXPIRED = "EXPIRED";
    private static final String TRACE_RESULT_FAILED = "FAILED";
    private static final String TRACE_RESULT_SUCCESS = "SUCCESS";
    private static final String TRACE_RESULT_SUCCESS_L1 = "SUCCESS_L1";
    private static final String TRACE_RESULT_SUCCESS_NO_ASR = "SUCCESS_NO_ASR";
    private static final String TRACE_RESULT_SUCCESS_NO_L1 = "SUCCESS_NO_L1";
    private static final String TRACE_STAGE_ASR_QUERY = "ASR_QUERY";
    private static final String TRACE_STAGE_ASR_SUBMIT = "ASR_SUBMIT";
    private static final String TRACE_STAGE_L0_COMMIT = "L0_COMMIT";
    private static final String TRACE_STAGE_TASK_PERSIST = "TASK_PERSIST";
    private static final int TRACE_VERSION = 2;
    private static final String UPLOAD_DIRECTORY = "auditory_memory";
    private static final String WARNING_WAV_DURATION_ADJUSTED = "auditory_wav_duration_adjusted";
    private static final long WAV_HEADER_SIZE = 44;
    private static final String WAV_SUFFIX = ".wav";
    private static final com.obric.memorydata.awareness.audio.d hotwordsCache = null;
    private static final o logger = null;
    private static final Object segmentGrantLock = null;
    private static final String segmentGrantSalt = null;
    private static final LinkedHashMap<String, c> segmentGrants = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$PreparedWav;", "", AuditoryBridgeAPIImpl.KEY_MANIFEST, "Lorg/json/JSONObject;", "usedTokens", "", "", "<init>", "(Lorg/json/JSONObject;Ljava/util/Set;)V", "getManifest", "()Lorg/json/JSONObject;", "getUsedTokens", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f8505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f8506b;

        public a(JSONObject r3, Set<String> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, AuditoryBridgeAPIImpl.KEY_MANIFEST);
            Intrinsics.checkNotNullParameter(r5, "usedTokens");
            this.f8505a = r3;
            this.f8506b = r5;
        }

        public final JSONObject a() {
            return this.f8505a;
        }

        public final Set<String> b() {
            return this.f8506b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8505a, r6.f8505a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8506b, r6.f8506b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8505a.hashCode() * 31) + this.f8506b.hashCode();
        }

        public String toString() {
            return "PreparedWav(manifest=" + this.f8505a + ", usedTokens=" + this.f8506b + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$PrivateSourceBatch;", "", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Ljava/io/File;", "usedTokens", "", "", "<init>", "(Ljava/util/List;Ljava/util/Set;)V", "getFiles", "()Ljava/util/List;", "getUsedTokens", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<File> f8507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f8508b;

        public b(List<? extends File> r3, Set<String> r4) {
            List<File> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, KevaImpl.PrivateConstants.FILES_DIR_NAME);
            Intrinsics.checkNotNullParameter(r6, "usedTokens");
            this.f8507a = r5;
            this.f8508b = r6;
        }

        public final List<File> a() {
            return this.f8507a;
        }

        public final Set<String> b() {
            return this.f8508b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8507a, r6.f8507a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8508b, r6.f8508b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8507a.hashCode() * 31) + this.f8508b.hashCode();
        }

        public String toString() {
            return "PrivateSourceBatch(files=" + this.f8507a + ", usedTokens=" + this.f8508b + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$SegmentGrant;", "", "originalFilePath", "", "startMs", "", "endMs", "durationMs", "readyAtMs", "<init>", "(Ljava/lang/String;JJJJ)V", "getOriginalFilePath", "()Ljava/lang/String;", "getStartMs", "()J", "getEndMs", "getDurationMs", "getReadyAtMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8510b;
        private final long c;
        private final long d;
        private final long e;

        public c(String r2, long r3, long r5, long r7, long r9) {
            Intrinsics.checkNotNullParameter(r2, "originalFilePath");
            this.f8509a = r2;
            this.f8510b = r3;
            this.c = r5;
            this.d = r7;
            this.e = r9;
        }

        public final String a() {
            return this.f8509a;
        }

        public final long b() {
            return this.f8510b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8509a, r10.f8509a) == true) goto L12;
            return false;
        L12:
            if (this.f8510b == r10.f8510b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f8509a.hashCode() * 31) + Long.hashCode(this.f8510b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e);
        }

        public String toString() {
            return "SegmentGrant(originalFilePath=" + this.f8509a + ", startMs=" + this.f8510b + ", endMs=" + this.c + ", durationMs=" + this.d + ", readyAtMs=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$TestWavDurationAdjustment;", "", "segmentIndex", "", "declaredDurationMs", "", "actualDurationMs", "<init>", "(IJJ)V", "getSegmentIndex", "()I", "getDeclaredDurationMs", "()J", "getActualDurationMs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8512b;
        private final long c;

        public d(int r1, long r2, long r4) {
            this.f8511a = r1;
            this.f8512b = r2;
            this.c = r4;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (this.f8511a == r10.f8511a) goto L12;
            return false;
        L12:
            if (this.f8512b == r10.f8512b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f8511a) * 31) + Long.hashCode(this.f8512b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "TestWavDurationAdjustment(segmentIndex=" + this.f8511a + ", declaredDurationMs=" + this.f8512b + ", actualDurationMs=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$TestWavSegment;", "", "file", "Ljava/io/File;", "startMs", "", "durationMs", "<init>", "(Ljava/io/File;JJ)V", "getFile", "()Ljava/io/File;", "getStartMs", "()J", "getDurationMs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f8513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8514b;
        private final long c;

        public final File a() {
            return this.f8513a;
        }

        public final long b() {
            return this.f8514b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8513a, r10.f8513a) == true) goto L12;
            return false;
        L12:
            if (this.f8514b == r10.f8514b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f8513a.hashCode() * 31) + Long.hashCode(this.f8514b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "TestWavSegment(file=" + this.f8513a + ", startMs=" + this.f8514b + ", durationMs=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavDurationAdjustment;", "", "segmentIndex", "", "declaredDurationMs", "", "actualDurationMs", "<init>", "(IJJ)V", "getSegmentIndex", "()I", "getDeclaredDurationMs", "()J", "getActualDurationMs", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8516b;
        private final long c;

        public f(int r1, long r2, long r4) {
            this.f8515a = r1;
            this.f8516b = r2;
            this.c = r4;
        }

        public final int a() {
            return this.f8515a;
        }

        public final long b() {
            return this.f8516b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
            return false;
        L8:
            f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
            if (this.f8515a == r10.f8515a) goto L12;
            return false;
        L12:
            if (this.f8516b == r10.f8516b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f8515a) * 31) + Long.hashCode(this.f8516b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "WavDurationAdjustment(segmentIndex=" + this.f8515a + ", declaredDurationMs=" + this.f8516b + ", actualDurationMs=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;", "", AuditoryBridgeAPIImpl.KEY_CHANNELS, "", "sampleRate", "", "bytesPerSecond", "blockAlign", "bitsPerSample", "<init>", "(IJJII)V", "getChannels", "()I", "getSampleRate", "()J", "getBytesPerSecond", "getBlockAlign", "getBitsPerSample", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8518b;
        private final long c;
        private final int d;
        private final int e;

        public g(int r1, long r2, long r4, int r6, int r7) {
            this.f8517a = r1;
            this.f8518b = r2;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }

        public final int a() {
            return this.f8517a;
        }

        public final long b() {
            return this.f8518b;
        }

        public final long c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
            return false;
        L8:
            g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
            if (this.f8517a == r10.f8517a) goto L12;
            return false;
        L12:
            if (this.f8518b == r10.f8518b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f8517a) * 31) + Long.hashCode(this.f8518b)) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "WavFormat(channels=" + this.f8517a + ", sampleRate=" + this.f8518b + ", bytesPerSecond=" + this.c + ", blockAlign=" + this.d + ", bitsPerSample=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavMergePlan;", "", "format", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;", "sources", "", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavSource;", "outputBytes", "", "<init>", "(Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;Ljava/util/List;J)V", "getFormat", "()Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;", "getSources", "()Ljava/util/List;", "getOutputBytes", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f8519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<i> f8520b;
        private final long c;

        public h(g r3, List<i> r4, long r5) {
            List<i> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "format");
            Intrinsics.checkNotNullParameter(r6, "sources");
            this.f8519a = r3;
            this.f8520b = r6;
            this.c = r5;
        }

        public final g a() {
            return this.f8519a;
        }

        public final List<i> b() {
            return this.f8520b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, h.class) == true) goto L8;
            return false;
        L8:
            h r8 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8519a, r8.f8519a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8520b, r8.f8520b) == true) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f8519a.hashCode() * 31) + this.f8520b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "WavMergePlan(format=" + this.f8519a + ", sources=" + this.f8520b + ", outputBytes=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavSource;", "", "file", "Ljava/io/File;", "format", "Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;", "dataOffset", "", "dataSize", "<init>", "(Ljava/io/File;Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;JJ)V", "getFile", "()Ljava/io/File;", "getFormat", "()Lcom/obric/memorydata/awareness/audio/AuditoryBridgeAPIImpl$WavFormat;", "getDataOffset", "()J", "getDataSize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f8521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f8522b;
        private final long c;
        private final long d;

        public i(File r2, g r3, long r4, long r6) {
            Intrinsics.checkNotNullParameter(r2, "file");
            Intrinsics.checkNotNullParameter(r3, "format");
            this.f8521a = r2;
            this.f8522b = r3;
            this.c = r4;
            this.d = r6;
        }

        public final File a() {
            return this.f8521a;
        }

        public final g b() {
            return this.f8522b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
            return false;
        L8:
            i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8521a, r10.f8521a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8522b, r10.f8522b) == true) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f8521a.hashCode() * 31) + this.f8522b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "WavSource(file=" + this.f8521a + ", format=" + this.f8522b + ", dataOffset=" + this.c + ", dataSize=" + this.d + ')';
        }
    }

    static {
        INSTANCE = new AuditoryBridgeAPIImpl();
        hotwordsCache = new com.obric.memorydata.awareness.audio.d();
        logger = com.obric.memorydata.middleware.api.logging.d.f11613a.a("AuditoryBridgeAPIImpl");
        ACTIVE_TASK_STATUSES = SetsKt.setOf(new String[]{TASK_STATUS_PENDING_UPLOAD, TASK_STATUS_PENDING_SUBMIT, TASK_STATUS_WAITING_RESULT});
        TERMINAL_TASK_STATUSES = SetsKt.setOf(new String[]{"DONE", RawObservationEntity.STATE_FAILED});
        RAW_TERMINAL_STATES = SetsKt.setOf(new String[]{"DONE", RawObservationEntity.STATE_FAILED});
        L0_VALIDATION_WARNING_CODE_REGEX = new Regex("[A-Z0-9_]{1,64}");
        TASK_ID_REGEX = new Regex("[A-Za-z0-9_-]{1,80}");
        segmentGrantLock = new Object();
        segmentGrants = new LinkedHashMap();
        String r0 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        segmentGrantSalt = r0;
    }

    private AuditoryBridgeAPIImpl() {
    }

    private final File accountPrivateSourceDirectory(String r3) {
        return new File(privateSourceRootDirectory(), sha256(r3));
    }

    /* JADX WARN: Type inference failed for: r5v14, types: [T, com.obric.memorydata.awareness.audio.AuditoryBridgeAPIImpl$g] */
    private final h buildWavMergePlan(JSONArray r23, List<? extends File> r24, Function1<? super f, Unit> r25) {
        final List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        if (r23.length() != r0.size()) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L38;
        ArrayList r4 = new ArrayList(r23.length());
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        long r8 = 0;
        int r10 = r23.length();
        final int r15 = 0;
    L9:
        if (r15 >= r10) goto L31;
        JSONObject r11 = r23.getJSONObject(r15);
        i r14 = (i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.audio.h.a("WAV_PARSE", r15, new $$Lambda$AuditoryBridgeAPIImpl$VhCvZKjo4d78Qt4o3PZrbA89Q0(r0, r15)), i.class, "com.obric.memorydata.plugin");
        long r16 = (r14.d() * 1000) / r14.b().c();
        long r18 = r11.getLong(KEY_DURATION_MS);
        if (Math.abs(r16 - r18) <= 1) goto L15;
        r2.invoke(new f(r15, r18, r16));
    L15:
        if (r7.element != 0) goto L17;
        r7.element = r14.b();
        final i r12 = r14;
    L18:
        r8 = r8 + r12.d();
        if (r15 <= 0) goto L22;
        r8 = r8 + (((g) ZeusTransformUtils.preCheckCast(r7.element, g.class, "com.obric.memorydata.plugin")).c() * 3);
    L22:
        if (r8 <= MAX_TOTAL_BYTES) goto L24;
    L26:
        boolean r5 = false;
    L27:
        if (r5 == false) goto L30;
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(r12);
        r15 = r15 + 1;
        goto L9
    L30:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L24:
        if (r8 > (((long) (-1)) & 4294967295L)) goto L26;
        r5 = true;
        goto L27
    L17:
        r12 = r14;
        com.obric.memorydata.awareness.audio.h.a("WAV_FORMAT", r15, new $$Lambda$AuditoryBridgeAPIImpl$UK294zcH0kK3YAy0bIyjqaRX9ok(r7, r12));
        goto L18
    L31:
        T r6 = r7.element;
        if (r6 == 0) goto L36;
        return new h((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), r8);
    L36:
        throw new IllegalArgumentException("Required value was null.".toString());
    L38:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L7
    }

    private static final i buildWavMergePlan$lambda$69(List r2, int r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return INSTANCE.parsePcmWav((File) ZeusTransformUtils.preCheckCast(r4.get(r3), File.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit buildWavMergePlan$lambda$70(Ref.ObjectRef r0, i r1) {
        com.obric.memorydata.awareness.audio.h.a(Intrinsics.areEqual(r0.element, r1.b()), "PCM_FORMAT_MISMATCH");
        return Unit.INSTANCE;
    }

    private final int cleanupExpiredTerminalTasks(List<AuditoryAsrTaskEntity> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        AuditoryAsrTaskDao r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r9.hasNext() == false) goto L8;
        AuditoryAsrTaskEntity r2 = (AuditoryAsrTaskEntity) ZeusTransformUtils.preCheckCast(r9.next(), AuditoryAsrTaskEntity.class, "com.obric.memorydata.plugin");
        INSTANCE.deleteUploadBundle(r2.getTaskId());
        com.obric.memorydata.awareness.audio.c.f8523a.b(r2.getAccountScope(), r2.getTaskId());
        if (r8.deleteByTaskId(r2.getTaskId(), r2.getAccountScope()) != 1) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    private final int cleanupPrivateSourceDirectories(long r12, Set<String> r14) {
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        File r11 = privateSourceRootDirectory();
        if (r11.exists() == true) goto L5;
        return 0;
    L5:
        File[] r13 = r11.listFiles();
        if (r13 != null) goto L8;
        r13 = new File[0];
    L8:
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r3 = r13.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        File r5 = r13[r4];
        if (r5.isDirectory() == false) goto L13;
        r0.add(r5);
    L13:
        r4 = r4 + 1;
        goto L9
    L14:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L16:
        if (r16.hasNext() == false) goto L45;
        File r6 = (File) ZeusTransformUtils.preCheckCast(r16.next(), File.class, "com.obric.memorydata.plugin");
        File[] r7 = r6.listFiles();
        if (r7 != null) goto L20;
        r7 = new File[0];
    L20:
        int r8 = r7.length;
        int r9 = 0;
    L21:
        if (r9 >= r8) goto L34;
        File r10 = r7[r9];
        if (r10.isDirectory() == false) goto L33;
        Regex r17 = TASK_ID_REGEX;
        String r18 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r18, "getName(...)");
        if (r17.matches((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L33;
        if (r15.contains(r10.getName()) == true) goto L33;
        if (r10.lastModified() > r12) goto L33;
        AuditoryBridgeAPIImpl r19 = INSTANCE;
        Intrinsics.checkNotNull(r10);
        if (r19.deleteDirectory(r10) == false) goto L33;
        r1 = r1 + 1;
    L33:
        r9 = r9 + 1;
        goto L21
    L34:
        File[] r20 = r6.listFiles();
        boolean r21 = true;
        if (r20 != null) goto L37;
    L43:
        if (r21 == false) goto L16;
        r6.delete();
        goto L16
    L37:
        if (r20.length != 0) goto L39;
        boolean r22 = true;
    L40:
        if (r22 == true) goto L43;
        r21 = false;
        goto L43
    L39:
        r22 = false;
        goto L40
    L45:
        return r1;
    }

    private static final void clearAccountData$lambda$57$lambda$56(MemoryFrameDb r1, String r2) {
        r1.getAuditoryAsrTaskDao().deleteByAccount(r2);
        r1.getAuditorySyncStateDao().deleteByAccount(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, java.lang.Object, java.util.List] */
    private static final void commitL0Result$lambda$46$lambda$45(MemoryFrameDb r24, String r25, String r26, List r27, Ref.IntRef r28, AuditoryBridgeAPIImpl r29, JSONObject r30, JSONArray r31, JSONObject r32, boolean r33, boolean r34, Ref.ObjectRef r35) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        AuditoryAsrTaskEntity r4 = r24.getAuditoryAsrTaskDao().queryByTaskId(r25);
        if (r4 == null) goto L74;
        if (Intrinsics.areEqual(r4.getAccountScope(), r26) == true) goto L7;
    L9:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L72;
        ?? r12 = r24.getRawObservationDao().insertAll(r2);
        if (r12.size() != r2.size()) goto L30;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L17;
    L19:
        Iterator r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L18;
        if (((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L21;
        boolean r9 = false;
    L28:
        if (r9 == false) goto L30;
        boolean r10 = true;
    L31:
        if (r10 == false) goto L70;
        r28.element = r29.insertEmbeddings(r30, r31, r12);
        String r11 = r4.getRequestLogIds();
        long r13 = r30.getLong(KEY_COMMITTED_AT);
        if (r13 < 0) goto L35;
        boolean r14 = true;
    L36:
        if (r14 == false) goto L68;
        long r17 = r30.optLong(KEY_TRACE_START_AT_MS, r13);
        if (r17 >= 0) goto L40;
    L42:
        boolean r15 = false;
    L43:
        long r16 = RangesKt.coerceIn(r17, 0, r13);
        JSONObject r0 = new JSONObject().put(KEY_RAW_COUNT, r2.size()).put(KEY_EMBEDDING_COUNT, r28.element).put(KEY_RAW_OBSERVATION_IDS, new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")));
        if (r32.length() <= 0) goto L46;
        r0.put(KEY_WARNING_COUNTS, r32);
    L46:
        com.obric.memorydata.awareness.audio.e r3 = com.obric.memorydata.awareness.audio.e.f8528a;
        JSONObject r1 = new JSONObject().put("v", 2).put(KEY_REQUEST_STAGE, TRACE_STAGE_L0_COMMIT).put(KEY_TRACE_RESULT, TRACE_RESULT_SUCCESS).put(KEY_TRACE_START_AT_MS, r16).put(KEY_TRACE_END_AT_MS, r13).put(KEY_TRACE_COST_MS, r13 - r16).put(KEY_TRACE_TIME_VALID, r15).put(KEY_TRACE_ATTEMPT, 1).put(KEY_LOG_ID, "").put("error_code", "").put(KEY_TRACE_DETAILS, r0);
        Intrinsics.checkNotNullExpressionValue(r1, "put(...)");
        if (r24.getAuditoryAsrTaskDao().updateRequestIds(r25, r26, "", "", r3.a(r11, r1), r30.getLong(KEY_COMMITTED_AT)) != 1) goto L49;
        boolean r18 = true;
    L50:
        if (r18 == false) goto L66;
        if (r33 == true) goto L53;
        String r19 = EVIDENCE_PARTIAL_IO;
    L56:
        AuditoryAsrTaskDao r20 = r24.getAuditoryAsrTaskDao();
        long r21 = r30.getLong(KEY_COMMITTED_AT);
        String r22 = r30.getString(KEY_OBSERVATION_ID);
        Intrinsics.checkNotNullExpressionValue(r22, "getString(...)");
        String r23 = new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r23, "toString(...)");
        if (r20.finishDone(r25, r26, r21, r22, r23, r19) != 1) goto L59;
        boolean r110 = true;
    L60:
        if (r110 == false) goto L64;
        r35.element = r12;
        return;
    L64:
        throw new IllegalStateException("Check failed.".toString());
    L59:
        r110 = false;
        goto L60
    L53:
        if (r34 == true) goto L55;
        r19 = EVIDENCE_PARTIAL_LOW_STORAGE;
        goto L56
    L55:
        r19 = EVIDENCE_COMPLETE;
        goto L56
    L66:
        throw new IllegalStateException("Check failed.".toString());
    L49:
        r18 = false;
        goto L50
    L40:
        if (r13 < r17) goto L42;
        r15 = true;
        goto L43
    L68:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L35:
        r14 = false;
        goto L36
    L70:
        throw new IllegalStateException("Check failed.".toString());
    L25:
        r8 = false;
    L18:
        r9 = true;
        goto L28
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L19;
    L30:
        r10 = false;
        goto L31
    L72:
        throw new IllegalStateException("Check failed.".toString());
    L7:
        if (Intrinsics.areEqual(r4.getStatus(), TASK_STATUS_WAITING_RESULT) == false) goto L9;
        r5 = true;
        goto L11
    L74:
        throw new IllegalStateException(ERROR_TASK_NOT_FOUND.toString());
    }

    private final com.obric.memorydata.awareness.audio.e.a completedL1Decision(AuditoryAsrTaskEntity r11, int r12, List<RawObservationEntity> r13) {
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        boolean r14 = ZeusTransformUtils.instanceOf(r10, Collection.class);
        String r1 = RawObservationEntity.STATE_FAILED;
        int r2 = 1;
        if (r14 == true) goto L5;
    L7:
        Iterator r15 = r10.iterator();
    L9:
        if (r15.hasNext() == false) goto L6;
        RawObservationEntity r16 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r15.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r16.getState(), RawObservationEntity.STATE_FAILED) == false) goto L13;
    L16:
        boolean r17 = true;
    L17:
        if (r17 == false) goto L9;
        boolean r18 = true;
    L19:
        int r9 = com.obric.memorydata.awareness.audio.e.f8528a.d(r11.getRequestLogIds());
        if (r18 == false) goto L23;
        r2 = 100;
    L22:
        int r5 = r2;
    L25:
        if (r18 == false) goto L27;
    L26:
        String r6 = r1;
        if (r18 == false) goto L32;
        String r19 = ERROR_CODE_L1_FAILED;
    L34:
        return new com.obric.memorydata.awareness.audio.e.a(r5, r6, r19, r12, r9);
    L32:
        r19 = "NONE";
        goto L34
    L27:
        if (r9 <= 0) goto L29;
        r1 = TRACE_RESULT_SUCCESS_L1;
        goto L26
    L29:
        r1 = TRACE_RESULT_SUCCESS_NO_L1;
        goto L26
    L23:
        if (r9 <= 0) goto L22;
        r5 = 0;
        goto L25
    L13:
        if (r16.getLastErrorCode() != 0) goto L16;
        r17 = false;
    L6:
        r18 = false;
        goto L19
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final void copyFileAtomically(File r16, File r17, long r18) {
        File r1 = new File(r17.getParentFile(), r17.getName() + ".tmp");
        boolean r3 = true;
        if (r1.exists() == true) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L63;
        long r6 = 0;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r16), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        BufferedInputStream r8 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r4, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        BufferedOutputStream r0 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r10, BufferedOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        byte[] r11 = new byte[8192];     // Catch: Throwable -> L45
    L15:
        int r12 = r8.read(r11);     // Catch: Throwable -> L45
        if (r12 < 0) goto L33;
        if (r12 <= 0) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L32;
        r6 = r6 + ((long) r12);     // Catch: Throwable -> L45
        if (r6 <= r18) goto L24;
    L26:
        boolean r14 = false;
    L27:
        if (r14 == false) goto L30;
        r0.write(r11, 0, r12);     // Catch: Throwable -> L45
        goto L15
    L30:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L45
    L24:
        if (r6 > MAX_TOTAL_BYTES) goto L26;
        r14 = true;
        goto L27
    L32:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L45
    L19:
        r13 = false;
        goto L20
    L33:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L45
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L52
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L52
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L59
        if (r6 == r18) goto L39;
    L41:
        r3 = false;
    L42:
        com.obric.memorydata.awareness.audio.h.a(r3, "SOURCE_SIZE_CHANGED");     // Catch: Throwable -> L59
        moveAtomically(r1, r17);     // Catch: Throwable -> L59
        r1.delete();
        return;
    L39:
        if (r16.length() != r18) goto L41;
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        r1.delete();
        throw th;
    L63:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r1.delete() == true) goto L8;
        r2 = false;
        goto L10
    }

    private final b copyGrantedSourcesToPrivate(JSONArray r22, File r23) {
        ArrayList r0 = new ArrayList(r22.length());
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r22.length();
        long r4 = 0;
        int r6 = 0;
    L4:
        if (r6 >= r2) goto L22;
        JSONObject r9 = r22.getJSONObject(r6);
        String r10 = r9.getString(KEY_SEGMENT_TOKEN);
        Intrinsics.checkNotNull(r10);
        c r3 = resolveSegmentGrant(r10, r9.getLong(KEY_START_MS), r9.getLong(KEY_END_MS), r9.getLong(KEY_DURATION_MS), r9.optLong(KEY_READY_AT_MS, -1));
        if (r1.add(r10) == false) goto L20;
        final File r11 = new File(r3.a());
        final long r12 = r11.length();
        com.obric.memorydata.awareness.audio.h.a("SOURCE_COPY", r6, new $$Lambda$AuditoryBridgeAPIImpl$jwhDYujkR9f9oAi9uwCoTzMX28M(r11, r12));
        r4 = r4 + r12;
        if (r4 > MAX_TOTAL_BYTES) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L18;
        int r16 = r2;
        File r7 = new File(r23, StringsKt.padStart(String.valueOf(r6), 3, '0'));
        if (r7.mkdirs() == false) goto L16;
        final File r8 = new File(r7, safeSourceFileName(r11));
        com.obric.memorydata.awareness.audio.h.a("SOURCE_COPY", r6, new $$Lambda$AuditoryBridgeAPIImpl$y9VosWk6QdVCSxgEU19qwTtifbE(r11, r8, r12));
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(r8);
        r6 = r6 + 1;
        r2 = r16;
        goto L4
    L16:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        r5 = false;
        goto L11
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L22:
        return new b((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit copyGrantedSourcesToPrivate$lambda$65(File r2, long r3) {
        com.obric.memorydata.awareness.audio.h.a(r2.isFile(), "SOURCE_MISSING");
        if (r3 < WAV_HEADER_SIZE) goto L5;
        boolean r4 = true;
    L6:
        com.obric.memorydata.awareness.audio.h.a(r4, "SOURCE_TOO_SHORT");
        return Unit.INSTANCE;
    L5:
        r4 = false;
        goto L6
    }

    private static final Unit copyGrantedSourcesToPrivate$lambda$66(File r1, File r2, long r3) {
        INSTANCE.copyFileAtomically(r1, r2, r3);
        return Unit.INSTANCE;
    }

    private final void copyWavData(i r8, BufferedOutputStream r9) {
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new RandomAccessFile(r8.a(), "r"), Closeable.class, "com.obric.memorydata.plugin");
        RandomAccessFile r0 = (RandomAccessFile) ZeusTransformUtils.preCheckCast(r7, RandomAccessFile.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        r0.seek(r8.c());     // Catch: Throwable -> L17
        long r1 = r8.d();     // Catch: Throwable -> L17
        byte[] r3 = new byte[8192];     // Catch: Throwable -> L17
    L5:
        if (r1 <= 0) goto L14;
        int r4 = r0.read(r3, 0, (int) Math.min(8192, r1));     // Catch: Throwable -> L17
        if (r4 <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L13;
        r9.write(r3, 0, r4);     // Catch: Throwable -> L17
        r1 = r1 - ((long) r4);     // Catch: Throwable -> L17
        goto L5
    L13:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L17
    L9:
        r6 = false;
        goto L10
    L14:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r7, null);
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    private final List<Long> decodeLongArray(String r5) {
        JSONArray r4 = new JSONArray(r5);
        int r6 = r4.length();
        ArrayList r0 = new ArrayList(r6);
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L6;
        r0.add(Long.valueOf(r4.getLong(r1)));
        r1 = r1 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private final List<RawObservationEntity> decodeRawRows(JSONArray r27) {
        int r0 = r27.length();
        ArrayList r1 = new ArrayList(r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L15;
        JSONObject r5 = r27.getJSONObject(r3);
        long r14 = r5.getLong(KEY_SPAN_START);
        long r16 = r5.getLong(KEY_SPAN_END);
        if (r14 >= 0) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L13;
        String r11 = r5.getString("device_id");
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        long r18 = r5.getLong("timestamp");
        String r2 = r5.getString("payload");
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        String r4 = r5.getString(KEY_META);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        String r7 = r5.getString("state");
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        r1.add(new RawObservationEntity(0, r11, SOURCE_AUDITORY, r18, r14, r16, r2, r4, r7, null, 0, 0, 3585, null));
        r3 = r3 + 1;
        goto L3
    L13:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        if (r16 <= r14) goto L9;
        r6 = true;
        goto L10
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    private final AuditoryAsrTaskEntity decodeTask(JSONObject r35) {
        String r4 = r35.getString(KEY_TASK_ID);
        String r5 = r35.getString(KEY_ACCOUNT_SCOPE);
        String r6 = r35.getString("status");
        long r7 = r35.getLong(KEY_AUDIO_START_MS);
        long r9 = r35.getLong(KEY_AUDIO_END_MS);
        Regex r2 = TASK_ID_REGEX;
        Intrinsics.checkNotNull(r4);
        boolean r3 = false;
        if (r2.matches((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        Intrinsics.checkNotNull(r5);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L23;
        if (Intrinsics.areEqual(r6, TASK_STATUS_PENDING_UPLOAD) == true) goto L13;
    L17:
        if (r3 == false) goto L21;
        TimeZone r10 = TimeZone.getDefault();
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNull(r10);
        String r11 = formatTime(r7, r10);
        String r12 = formatTime(r9, r10);
        String r0 = r10.getID();
        Intrinsics.checkNotNullExpressionValue(r0, "getID(...)");
        String r1 = r35.getString(KEY_AUDIO_PATH);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        String r13 = r35.getString(KEY_MANIFEST);
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        String r14 = r35.getString(KEY_AUDIO_SHA256);
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        com.obric.memorydata.awareness.audio.e r15 = com.obric.memorydata.awareness.audio.e.f8528a;
        String r16 = r35.optString(KEY_REQUEST_LOG_IDS, "[]");
        Intrinsics.checkNotNullExpressionValue(r16, "optString(...)");
        return new AuditoryAsrTaskEntity(r4, r5, r6, r7, r9, r11, r12, r0, r1, r13, r14, null, 0, "", 0, null, null, null, null, r15.a(r16), null, r35.getLong(KEY_CREATED_AT), r35.getLong(KEY_UPDATED_AT), 1558528, null);
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L13:
        if (r7 < 0) goto L17;
        if (r9 < r7) goto L17;
        r3 = true;
        goto L17
    L23:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        r8 = false;
        goto L9
    }

    private final JSONObject decodeValidationWarnings(JSONObject r5) {
        JSONObject r4 = r5.optJSONObject(KEY_VALIDATION_WARNINGS);
        if (r4 == null) goto L5;
        Iterator<String> r6 = r4.keys();
        Intrinsics.checkNotNullExpressionValue(r6, "keys(...)");
    L8:
        if (r6.hasNext() == false) goto L21;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        Regex r1 = L0_VALIDATION_WARNING_CODE_REGEX;
        Intrinsics.checkNotNull(r0);
        if (r1.matches((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L20;
        if (r4.getInt(r0) <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L8;
        throw new IllegalArgumentException("Failed requirement.".toString());
    L14:
        r2 = false;
        goto L15
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L21:
        return r4;
    L5:
        return new JSONObject();
    }

    private final boolean deleteDirectory(File r1) {
        if (r1.exists() == true) goto L5;
    L8:
        return true;
    L5:
        if (FilesKt.deleteRecursively(r1) == true) goto L8;
        return false;
    }

    private final boolean deletePrivateSourceDirectories(String r9) {
        File r8 = privateSourceRootDirectory();
        if (r8.exists() == true) goto L5;
        return true;
    L5:
        File[] r10 = r8.listFiles();
        if (r10 != null) goto L8;
        r10 = new File[0];
    L8:
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r3 = r10.length;
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L14;
        File r6 = r10[r5];
        if (r6.isDirectory() == false) goto L13;
        r2.add(r6);
    L13:
        r5 = r5 + 1;
        goto L9
    L14:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r4 = true;
    L16:
        if (r11.hasNext() == false) goto L34;
        File r7 = (File) ZeusTransformUtils.preCheckCast(r11.next(), File.class, "com.obric.memorydata.plugin");
        if (INSTANCE.deleteDirectory(new File(r7, r9)) == false) goto L21;
        if (r4 == false) goto L21;
        r4 = true;
    L22:
        File[] r12 = r7.listFiles();
        if (r12 != null) goto L25;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == false) goto L16;
        r7.delete();
        goto L16
    L25:
        if (r12.length != 0) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == true) goto L31;
        r13 = false;
        goto L32
    L27:
        r14 = false;
    L21:
        r4 = false;
        goto L22
    L34:
        return r4;
    }

    private final String errorResponse(String r3) {
        String r2 = new JSONObject().put(KEY_CODE, -1).put("error", r3).toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    private final com.obric.memorydata.awareness.audio.e.a expiredDecision(AuditoryAsrTaskEntity r7, int r8) {
        return new com.obric.memorydata.awareness.audio.e.a(101, TRACE_RESULT_EXPIRED, ERROR_CODE_TASK_EXPIRED, r8, com.obric.memorydata.awareness.audio.e.f8528a.d(r7.getRequestLogIds()));
    }

    private final com.obric.memorydata.awareness.audio.e.a failedDecision(AuditoryAsrTaskEntity r9, int r10) {
        String r8 = r9.getLastError();
        String r0 = ERROR_CODE_TASK_EXPIRED;
        boolean r11 = Intrinsics.areEqual(r8, ERROR_CODE_TASK_EXPIRED);
        if (r11 == false) goto L5;
        int r1 = 101;
    L6:
        int r2 = r1;
        if (r11 == false) goto L9;
        String r3 = TRACE_RESULT_EXPIRED;
    L10:
        String r4 = r3;
        if (r11 == true) goto L15;
        r0 = com.obric.memorydata.awareness.audio.e.f8528a.a(r9.getLastError(), r9.getRequestLogIds());
    L15:
        return new com.obric.memorydata.awareness.audio.e.a(r2, r4, r0, r10, 0);
    L9:
        r3 = RawObservationEntity.STATE_FAILED;
        goto L10
    L5:
        r1 = 100;
        goto L6
    }

    private final JSONObject finalizeTaskTelemetryTransaction(final String r10, final String r11, final long r12) {
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        final MemoryFrameDb r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();
        r7.runInTransaction(new $$Lambda$AuditoryBridgeAPIImpl$hKGi5rG7uSMeyEF3RpLJspbAfGo(r7, r10, r11, r12, r9));
        return (JSONObject) ZeusTransformUtils.preCheckCast(r9.element, JSONObject.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, org.json.JSONObject] */
    private static final void finalizeTaskTelemetryTransaction$lambda$37(MemoryFrameDb r34, String r35, String r36, long r37, Ref.ObjectRef r39) {
        AuditoryAsrTaskEntity r0 = r34.getAuditoryAsrTaskDao().queryByTaskId(r35);
        if (r0 == null) goto L28;
        if (Intrinsics.areEqual(r0.getAccountScope(), r36) == false) goto L26;
        if (com.obric.memorydata.awareness.audio.e.f8528a.b(r0.getRequestLogIds()) == false) goto L9;
        return;
    L9:
        AuditoryBridgeAPIImpl r3 = INSTANCE;
        List<Long> r5 = r3.decodeLongArray(r0.getRawObservationIds());
        if (r5.isEmpty() == false) goto L12;
        List<RawObservationEntity> r1 = CollectionsKt.emptyList();
    L13:
        com.obric.memorydata.awareness.audio.e.a r8 = r3.terminalDecision$awareness_obricRelease(r0, r5, r1, r37);
        if (r8 != null) goto L16;
        return;
    L16:
        String r15 = com.obric.memorydata.awareness.audio.e.f8528a.a(r0.getRequestLogIds(), com.obric.memorydata.awareness.audio.e.f8528a.a(r8, com.obric.memorydata.awareness.audio.e.f8528a.a(r0.getRequestLogIds(), r37), r37, com.obric.memorydata.awareness.audio.e.f8528a.a(r0.getRequestLogIds(), r8)));
        boolean r2 = true;
        if (r34.getAuditoryAsrTaskDao().markPipelineTerminal(r35, r36, r0.getRequestLogIds(), r15, r37) == 1) goto L20;
        r2 = false;
    L20:
        if (r2 == false) goto L24;
        r39.element = com.obric.memorydata.awareness.audio.e.f8528a.a(AuditoryAsrTaskEntity.copy$default(r0, null, null, null, 0, 0, null, null, null, null, null, null, null, 0, null, r37, null, null, null, null, r15, null, 0, r37, 3653631, null), r8, r15);
        return;
    L24:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r1 = r34.getRawObservationDao().queryByIds(r5);
        goto L13
    L26:
        throw new IllegalStateException("Check failed.".toString());
    L28:
        throw new IllegalStateException(ERROR_TASK_NOT_FOUND.toString());
    }

    private final String formatTime(long r3, TimeZone r5) {
        SimpleDateFormat r2 = new SimpleDateFormat(TIME_FORMAT, Locale.US);
        r2.setTimeZone(r5);
        String r4 = r2.format(new Date(r3));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return r4;
    }

    @JvmStatic
    public static final AuditoryBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private final List<Pair<AlwaysOnAudioSegment, String>> grantSegments(List<AlwaysOnAudioSegment> r21, boolean r22) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        AlwaysOnAudioSegment r3 = (AlwaysOnAudioSegment) ZeusTransformUtils.preCheckCast(r2.next(), AlwaysOnAudioSegment.class, "com.obric.memorydata.plugin");
        r1.add(TuplesKt.to(r3, INSTANCE.sha256(segmentGrantSalt + 0 + r3.getOriginalFilePath() + 0 + r3.getTimestampMillis() + 0 + r3.getDurationMillis())));
        goto L4
    L6:
        List<Pair<AlwaysOnAudioSegment, String>> r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        Object r5 = segmentGrantLock;
        monitor-enter(r5);
        if (r22 == true) goto L34;
    L10:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L31
    L12:
        if (r6.hasNext() == false) goto L28;
        Pair r7 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        AlwaysOnAudioSegment r8 = (AlwaysOnAudioSegment) ZeusTransformUtils.preCheckCast(r7.component1(), AlwaysOnAudioSegment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.component2(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(segmentGrants, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        String r11 = r8.getOriginalFilePath();     // Catch: Throwable -> L31
        long r12 = r8.getTimestampMillis();     // Catch: Throwable -> L31
        long r13 = r8.getEndTimestampMillis();     // Catch: Throwable -> L31
        long r14 = r8.getDurationMillis();     // Catch: Throwable -> L31
        File r15 = new File(r8.getOriginalFilePath());     // Catch: Throwable -> L31
        Long r16 = null;
        if (r15.isFile() == true) goto L17;
        r15 = null;
    L17:
        if (r15 == null) goto L26;
        Long r17 = Long.valueOf(r15.lastModified());     // Catch: Throwable -> L31
        if (((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L21;
        boolean r18 = true;
    L22:
        if (r18 == false) goto L24;
        r16 = r17;
    L24:
        if (r16 == null) goto L26;
        long r19 = r16.longValue();     // Catch: Throwable -> L31
    L27:
        r10.put(r9, new c(r11, r12, r13, r14, r19));     // Catch: Throwable -> L31
        goto L12
    L21:
        r18 = false;
    L26:
        r19 = -1;
        goto L27
    L28:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r5);
        return r4;
    L31:
        th = move-exception;
        throw th;
    L34:
        segmentGrants.clear();     // Catch: Throwable -> L31
        goto L10
    }

    static /* synthetic */ List grantSegments$default(AuditoryBridgeAPIImpl r1, List r2, boolean r3, int r4, Object r5) {
        List<AlwaysOnAudioSegment> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = true;
    L6:
        return r1.grantSegments(r6, r3);
    }

    private final int insertEmbeddings(JSONObject r22, JSONArray r23, List<Long> r24) {
        String r1 = "com.obric.memorydata.plugin";
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        MemoryFrameDb r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();
        long r16 = r22.getLong(KEY_COMMITTED_AT);
        int r3 = r23.length();
        int r14 = 0;
    L3:
        if (r14 >= r3) goto L36;
        JSONObject r4 = r23.getJSONObject(r14);
        JSONArray r5 = r4.getJSONArray(KEY_VECTORS);
        boolean r8 = true;
        if (r5.length() != 256) goto L7;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L34;
        int r7 = r5.length();
        int r9 = 0;
    L11:
        if (r9 >= r7) goto L22;
        double r10 = r5.getDouble(r9);
        if (Double.isInfinite(r10) == false) goto L15;
    L17:
        boolean r11 = false;
    L18:
        if (r11 == false) goto L21;
        r9 = r9 + 1;
        goto L11
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L15:
        if (Double.isNaN(r10) == true) goto L17;
        r11 = true;
        goto L18
    L22:
        JSONArray r12 = r4.getJSONArray(KEY_RAW_INDEXES);
        JSONArray r13 = new JSONArray();
        int r15 = r12.length();
        int r17 = 0;
    L23:
        if (r17 >= r15) goto L26;
        r13.put(((Number) ZeusTransformUtils.preCheckCast(r0.get(r12.getInt(r17)), Number.class, r1)).longValue());
        r17 = r17 + 1;
        goto L23
    L26:
        if (r13.length() > 0) goto L29;
        r8 = false;
    L29:
        if (r8 == false) goto L32;
        SpeakerEmbeddingPendingDao r18 = r2.getSpeakerEmbeddingPendingDao();
        String r19 = r4.getString(KEY_EMBEDDING_ID);
        Intrinsics.checkNotNullExpressionValue(r19, "getString(...)");
        String r20 = r4.getString("session_id");
        Intrinsics.checkNotNullExpressionValue(r20, "getString(...)");
        String r110 = r4.getString(KEY_LOCAL_SPEAKER_ID);
        Intrinsics.checkNotNullExpressionValue(r110, "getString(...)");
        String r111 = r4.getString(KEY_MODEL_VERSION);
        Intrinsics.checkNotNullExpressionValue(r111, "getString(...)");
        String r21 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r21, "toString(...)");
        String r25 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r25, "toString(...)");
        r18.insert(new SpeakerEmbeddingPendingEntity(r19, r20, r110, r111, r21, r25, SpeakerEmbeddingPendingEntity.STATE_COMMITTED, r16, r16));
        r14 = r14 + 1;
        r0 = r0;
        r1 = r1;
        goto L3
    L32:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L34:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        r6 = false;
        goto L9
    L36:
        return r23.length();
    }

    private final boolean isCurrentAccountAllowed(String r4) {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L9:
        return false;
    L5:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L9;
        if (Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(UserSettings.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), r4) == false) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: lambda$BNi-yzvgAXeszi7uuU8oil3bFJg, reason: not valid java name */
    public static /* synthetic */ void m473lambda$BNiyzvgAXeszi7uuU8oil3bFJg(MemoryFrameDb r0, AuditoryAsrTaskEntity r1, long r2, long r4, long r6) {
        persistTaskAndCursor$lambda$27$lambda$26(r0, r1, r2, r4, r6);
    }

    public static /* synthetic */ void lambda$DKfEpq43ikGqNTHm8WdeSmDiR2I(MemoryFrameDb r0, String r1, String r2, List r3, Ref.IntRef r4, AuditoryBridgeAPIImpl r5, JSONObject r6, JSONArray r7, JSONObject r8, boolean r9, boolean r10, Ref.ObjectRef r11) {
        commitL0Result$lambda$46$lambda$45(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ b lambda$ISBql8UY_OTlvShV8e3MaWAFfb4(JSONArray r0, File r1) {
        return preparePrivateWav$lambda$62(r0, r1);
    }

    public static /* synthetic */ Unit lambda$MrWA9ead1uPtSCXo56tVxkp99I0() {
        return preparePrivateWav$lambda$60();
    }

    public static /* synthetic */ CharSequence lambda$O23RAJzPNOwosAzuYQ8Bwkm0_kM(byte r0) {
        return sha256$lambda$91(r0);
    }

    /* JADX INFO: renamed from: lambda$P_lsL0S6W1lrh-y-e_Ln7tdYhD4, reason: not valid java name */
    public static /* synthetic */ CharSequence m474lambda$P_lsL0S6W1lrhye_Ln7tdYhD4(byte r0) {
        return sha256$lambda$92(r0);
    }

    /* JADX INFO: renamed from: lambda$QnQ_OP-AQ5JMldQgiY8AV7BKpO4, reason: not valid java name */
    public static /* synthetic */ Unit m475lambda$QnQ_OPAQ5JMldQgiY8AV7BKpO4(com.obric.memorydata.middleware.api.logging.g r0) {
        return queryHotwords$lambda$6(r0);
    }

    public static /* synthetic */ void lambda$Ro0xA4P7oRiRv7cKcDQuOYQ5LF0(MemoryFrameDb r0, String r1) {
        clearAccountData$lambda$57$lambda$56(r0, r1);
    }

    public static /* synthetic */ Unit lambda$UK294zcH0kK3YAy0bIyjqaRX9ok(Ref.ObjectRef r0, i r1) {
        return buildWavMergePlan$lambda$70(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$VhCvZKjo4d78Qt4o3PZrbA89Q-0, reason: not valid java name */
    public static /* synthetic */ i m476lambda$VhCvZKjo4d78Qt4o3PZrbA89Q0(List r0, int r1) {
        return buildWavMergePlan$lambda$69(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$W-oj1pEZIlTEnN2K58ZRiBiOU-g, reason: not valid java name */
    public static /* synthetic */ Unit m477lambda$Woj1pEZIlTEnN2K58ZRiBiOUg(AuditoryBridgeAPIImpl r0, String r1, f r2) {
        return prepareUploadWav$lambda$20$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$XqFZ37HeOUOXfeOy4KjOmquWaWY(String r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return queryHotwords$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ void lambda$hKGi5rG7uSMeyEF3RpLJspbAfGo(MemoryFrameDb r0, String r1, String r2, long r3, Ref.ObjectRef r5) {
        finalizeTaskTelemetryTransaction$lambda$37(r0, r1, r2, r3, r5);
    }

    public static /* synthetic */ Unit lambda$jZwogk_4S8CscLTHe6TspdnGcdA(Function1 r0, f r1) {
        return mergePcmWavForTest$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$jrWeX6T_74dICFqYzAJAhmYLLeg(MemoryFrameDb r0, String r1, String r2, JSONObject r3) {
        recordTaskRequestEvent$lambda$32$lambda$31(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$jwhDYujkR9f9oAi9uwCoTzMX28M(File r0, long r1) {
        return copyGrantedSourcesToPrivate$lambda$65(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$nWiX-2C0O-6fUA-etMc9k6Q0uaE, reason: not valid java name */
    public static /* synthetic */ a m478lambda$nWiX2C0O6fUAetMc9k6Q0uaE(File r0, JSONArray r1, b r2, Function1 r3) {
        return preparePrivateWav$lambda$63(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$p09BQb_sDgDwzYUwLs7LdUxzcVY(List r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return logCommittedRawSpans$lambda$48(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$pGuXy7A-XIP_1p6OB2fD4BDrukc, reason: not valid java name */
    public static /* synthetic */ Unit m479lambda$pGuXy7AXIP_1p6OB2fD4BDrukc(WavPreparationFailure r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return prepareUploadWav$lambda$22$lambda$21(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tGvFmWC3TojUBMyO6dA-8ohe1CM, reason: not valid java name */
    public static /* synthetic */ Unit m480lambda$tGvFmWC3TojUBMyO6dA8ohe1CM(d r0) {
        return mergePcmWavForTest$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$vrZqAZ5ZruxZvdq12pBz55YLuqE(File r0, File r1) {
        return preparePrivateWav$lambda$64(r0, r1);
    }

    public static /* synthetic */ Unit lambda$wtKVh0jwrULv7LDxAcTR_VZqR7k() {
        return mergePcmWavForTest$lambda$1();
    }

    public static /* synthetic */ CharSequence lambda$x24Ch9JhgAlkmgY8ZjIPKILWQSY(List r0, List r1, int r2) {
        return logCommittedRawSpans$lambda$51$lambda$49(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$xoBkRc700172QverehQRXQsZLrA(Throwable r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return queryHotwords$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit lambda$y9VosWk6QdVCSxgEU19qwTtifbE(File r0, File r1, long r2) {
        return copyGrantedSourcesToPrivate$lambda$66(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$yeVS7fXTfQ0nEQHytHaNfuTX1d4(Ref.LongRef r0, AuditoryBridgeAPIImpl r1, String r2) {
        return prepareUploadWav$lambda$20$lambda$19(r0, r1, r2);
    }

    private final void logCommittedRawSpans(String r22, List<Long> r23, List<RawObservationEntity> r24) {
        final List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        final List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r11 = new com.obric.memorydata.middleware.api.logging.e(null, r22, "l0_commit", 1, null);
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin"), "听觉原始观察写入完成", "auditory_l0_committed", r11, new $$Lambda$AuditoryBridgeAPIImpl$p09BQb_sDgDwzYUwLs7LdUxzcVY(r0), null, 16, null);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 4), Iterable.class, "com.obric.memorydata.plugin"), 4), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3.next(), List.class, "com.obric.memorydata.plugin");
        String r5 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$AuditoryBridgeAPIImpl$x24Ch9JhgAlkmgY8ZjIPKILWQSY(r0, r2), 30, null);
        o r6 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        if (AppContext.INSTANCE.isDebug() == false) goto L4;
        String r7 = "auditory_raw_spans task_id=" + r22 + " offset=" + ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r4), Number.class, "com.obric.memorydata.plugin")).intValue() + " id:start_ms:end_ms=" + r5;
        com.obric.memorydata.middleware.api.logging.g r8 = new com.obric.memorydata.middleware.api.logging.g();
        Unit r9 = Unit.INSTANCE;
        r6.a(r7, r11, r8.a());
        goto L4
    }

    private static final Unit logCommittedRawSpans$lambda$48(List r2, com.obric.memorydata.middleware.api.logging.g r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a(KEY_RAW_COUNT, Integer.valueOf(r4.size()));
        return Unit.INSTANCE;
    }

    private static final CharSequence logCommittedRawSpans$lambda$51$lambda$49(List r4, List r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        return (CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append(((Number) ZeusTransformUtils.preCheckCast(r7.get(r6), Number.class, "com.obric.memorydata.plugin")).longValue()).append(':').append(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r8.get(r6), RawObservationEntity.class, "com.obric.memorydata.plugin")).getSpanStart()).append(':').append(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r8.get(r6), RawObservationEntity.class, "com.obric.memorydata.plugin")).getSpanEnd()).toString(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final a mergePcmWav(File r3, JSONArray r4, b r5, Function1<? super f, Unit> r6) {
        Function1<? super f, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        h r8 = buildWavMergePlan(r4, r5.a(), r7);
        JSONArray r2 = writeMergedWav(r3, r4, r8);
        JSONObject r9 = new JSONObject().put("version", 1).put(KEY_SAMPLE_RATE, r8.a().b()).put(KEY_CHANNELS, r8.a().a()).put(KEY_BITS_PER_SAMPLE, r8.a().e()).put(KEY_SEGMENTS, r2);
        Intrinsics.checkNotNull(r9);
        return new a(r9, r5.b());
    }

    public static /* synthetic */ JSONObject mergePcmWavForTest$awareness_obricRelease$default(AuditoryBridgeAPIImpl r7, File r8, List r9, File r10, boolean r11, Function1 r12, Function0 r13, int r14, Object r15) {
        List<e> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Function1<? super d, Unit> r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        if ((r14 & 4) == 0) goto L5;
        File r3 = new File(r8.getParentFile(), '.' + r8.getName() + ".sources");
    L7:
        if ((r14 & 8) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r14 & 16) == 0) goto L14;
        r2 = $$Lambda$AuditoryBridgeAPIImpl$tGvFmWC3TojUBMyO6dA8ohe1CM.INSTANCE;
    L14:
        if ((r14 & 32) == 0) goto L17;
        r1 = $$Lambda$AuditoryBridgeAPIImpl$wtKVh0jwrULv7LDxAcTR_VZqR7k.INSTANCE;
    L17:
        return r7.mergePcmWavForTest$awareness_obricRelease(r8, r0, r3, r4, r2, r1);
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    private static final Unit mergePcmWavForTest$lambda$0(d r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit mergePcmWavForTest$lambda$1() {
        return Unit.INSTANCE;
    }

    private static final Unit mergePcmWavForTest$lambda$5(Function1 r7, f r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "adjustment");
        r9.invoke(new d(r8.a(), r8.b(), r8.c()));
        return Unit.INSTANCE;
    }

    private final void moveAtomically(File r3, File r4) {
        Files.move(r3.toPath(), r4.toPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});
    }

    private final i parsePcmWav(File r25) {
        if (r25.isFile() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        com.obric.memorydata.awareness.audio.h.a(r0, "SOURCE_UNREADABLE_OR_SHORT");
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new RandomAccessFile(r25, "r"), Closeable.class, "com.obric.memorydata.plugin");
        RandomAccessFile r1 = (RandomAccessFile) ZeusTransformUtils.preCheckCast(r3, RandomAccessFile.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        AuditoryBridgeAPIImpl r4 = INSTANCE;     // Catch: Throwable -> L62
        com.obric.memorydata.awareness.audio.h.a(Intrinsics.areEqual(r4.readFourCc(r1), "RIFF"), "RIFF_MAGIC_INVALID");     // Catch: Throwable -> L62
        long r10 = 8;
        if (r4.readUInt32Le(r1) != (r1.length() - 8)) goto L14;
        boolean r6 = true;
    L15:
        com.obric.memorydata.awareness.audio.h.a(r6, "RIFF_SIZE_MISMATCH");     // Catch: Throwable -> L62
        com.obric.memorydata.awareness.audio.h.a(Intrinsics.areEqual(r4.readFourCc(r1), "WAVE"), "WAVE_MAGIC_INVALID");     // Catch: Throwable -> L62
        long r13 = -1;
        long r7 = -1;
        g r8 = null;
    L17:
        if (r1.getFilePointer() >= r1.length()) goto L46;
        if ((r1.getFilePointer() + r10) > r1.length()) goto L21;
        boolean r5 = true;
    L22:
        com.obric.memorydata.awareness.audio.h.a(r5, "CHUNK_HEADER_TRUNCATED");     // Catch: Throwable -> L62
        AuditoryBridgeAPIImpl r9 = INSTANCE;     // Catch: Throwable -> L62
        String r11 = r9.readFourCc(r1);     // Catch: Throwable -> L62
        long r2 = r9.readUInt32Le(r1);     // Catch: Throwable -> L62
        long r18 = r1.getFilePointer();     // Catch: Throwable -> L62
        long r20 = r18 + r2;     // Catch: Throwable -> L62
        if (r20 >= r18) goto L25;
    L27:
        boolean r12 = false;
    L28:
        com.obric.memorydata.awareness.audio.h.a(r12, "CHUNK_DATA_TRUNCATED");     // Catch: Throwable -> L62
        if (Intrinsics.areEqual(r11, "fmt ") == false) goto L35;
        if (r8 != null) goto L32;
        boolean r14 = true;
    L33:
        com.obric.memorydata.awareness.audio.h.a(r14, "FMT_CHUNK_DUPLICATED");     // Catch: Throwable -> L62
        r8 = r9.readPcmFormat(r1, r2);     // Catch: Throwable -> L62
    L41:
        long r15 = r20 + (r2 & 1);     // Catch: Throwable -> L62
        if (r15 > r1.length()) goto L44;
        boolean r16 = true;
    L45:
        com.obric.memorydata.awareness.audio.h.a(r16, "CHUNK_PADDING_TRUNCATED");     // Catch: Throwable -> L62
        r1.seek(r15);     // Catch: Throwable -> L62
        r10 = 8;
        goto L17
    L44:
        r16 = false;
        goto L45
    L32:
        r14 = false;
        goto L33
    L35:
        if (Intrinsics.areEqual(r11, "data") == false) goto L41;
        if (r7 >= 0) goto L39;
        boolean r17 = true;
    L40:
        com.obric.memorydata.awareness.audio.h.a(r17, "DATA_CHUNK_DUPLICATED");     // Catch: Throwable -> L62
        r13 = r2;
        r7 = r18;
        goto L41
    L39:
        r17 = false;
        goto L40
    L25:
        if (r20 > r1.length()) goto L27;
        r12 = true;
        goto L28
    L21:
        r5 = false;
        goto L22
    L46:
        if (r8 == null) goto L61;
        if (r1.getFilePointer() == r1.length()) goto L50;
    L56:
        boolean r19 = false;
    L57:
        com.obric.memorydata.awareness.audio.h.a(r19, "PCM_DATA_INVALID");     // Catch: Throwable -> L62
        i r21 = new i(r25, r8, r7, r13);     // Catch: Throwable -> L62
        CloseableKt.closeFinally(r3, null);
        return r21;
    L50:
        if (r7 < 0) goto L56;
        if (r13 <= 0) goto L56;
        if ((r13 % ((long) r8.d())) != 0) goto L56;
        r19 = true;
        goto L57
    L61:
        throw new WavPreparationFailure("", -1, "FMT_CHUNK_MISSING", null, 8, null);     // Catch: Throwable -> L62
    L14:
        r6 = false;
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L5:
        if (r25.canRead() == false) goto L9;
        if (r25.length() < WAV_HEADER_SIZE) goto L9;
        r0 = true;
        goto L10
    }

    private static final void persistTaskAndCursor$lambda$27$lambda$26(MemoryFrameDb r13, AuditoryAsrTaskEntity r14, long r15, long r17, long r19) {
        AuditorySyncStateEntity r0 = r13.getAuditorySyncStateDao().query(r14.getAccountScope());
        if (r0 == null) goto L5;
        long r1 = r0.getLastFileEndMs();
    L6:
        boolean r2 = false;
        if (r1 != r15) goto L9;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L34;
        AuditoryAsrTaskEntity r4 = r13.getAuditoryAsrTaskDao().queryByTaskId(r14.getTaskId());
        if (r4 != null) goto L23;
        if (r13.getAuditoryAsrTaskDao().insert(r14) == (-1)) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L23;
        throw new IllegalStateException("Check failed.".toString());
    L17:
        r5 = false;
    L23:
        r13.getAuditorySyncStateDao().upsert(new AuditorySyncStateEntity(r14.getAccountScope(), r17, r19));
        if (r4 != null) goto L32;
        long r6 = System.currentTimeMillis();
        long r8 = com.obric.memorydata.awareness.audio.e.f8528a.a(r14.getRequestLogIds(), r6);
        com.obric.memorydata.awareness.audio.e r7 = com.obric.memorydata.awareness.audio.e.f8528a;
        String r9 = r14.getRequestLogIds();
        JSONObject r10 = new JSONObject().put("v", 2).put(KEY_REQUEST_STAGE, TRACE_STAGE_TASK_PERSIST).put(KEY_TRACE_RESULT, TRACE_RESULT_SUCCESS).put(KEY_TRACE_START_AT_MS, r8).put(KEY_TRACE_END_AT_MS, r6).put(KEY_TRACE_COST_MS, r6 - r8).put(KEY_TRACE_TIME_VALID, true).put(KEY_TRACE_ATTEMPT, 1).put(KEY_LOG_ID, "").put("error_code", "").put(KEY_TRACE_DETAILS, new JSONObject());
        Intrinsics.checkNotNullExpressionValue(r10, "put(...)");
        if (r13.getAuditoryAsrTaskDao().updateRequestIds(r14.getTaskId(), r14.getAccountScope(), "", "", r7.a(r9, r10), r6) != 1) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L31;
        return;
    L31:
        throw new IllegalStateException("Check failed.".toString());
    L32:
        return;
    L34:
        throw new IllegalStateException("Check failed.".toString());
    L9:
        r3 = false;
        goto L11
    L5:
        r1 = 0;
        goto L6
    }

    private final a preparePrivateWav(final File r10, final JSONArray r11, final File r12, boolean r13, Function1<? super f, Unit> r14, Function0<Unit> r15) {
        final Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Function0 r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        File r1 = r10.getParentFile();
        boolean r3 = true;
        if (r1 != null) goto L5;
    L13:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L67;
        if (r10.exists() == true) goto L19;
    L22:
        boolean r4 = true;
    L23:
        if (r4 == false) goto L65;
        if (deleteDirectory(r12) == false) goto L63;
        if (r12.mkdirs() == false) goto L61;
        final File r5 = new File(r10.getParentFile(), r10.getName() + ".tmp");
        if (r5.exists() == true) goto L31;
    L34:
        boolean r6 = true;
    L35:
        if (r6 == false) goto L59;
        final b r7 = (b) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.audio.h.a("SOURCE_COPY", 0, new $$Lambda$AuditoryBridgeAPIImpl$ISBql8UY_OTlvShV8e3MaWAFfb4(r11, r12), 2, null), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        r17.invoke();     // Catch: Throwable -> L49
        a r18 = (a) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.audio.h.a("WAV_MERGE", 0, new $$Lambda$AuditoryBridgeAPIImpl$nWiX2C0O6fUAetMc9k6Q0uaE(r5, r11, r7, r16), 2, null), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        com.obric.memorydata.awareness.audio.h.a("OUTPUT_COMMIT", 0, new $$Lambda$AuditoryBridgeAPIImpl$vrZqAZ5ZruxZvdq12pBz55YLuqE(r5, r10), 2, null);     // Catch: Throwable -> L49
        r5.delete();
        if (r13 == false) goto L40;
    L43:
        if (r3 == true) goto L45;
        r10.delete();
    L45:
        if (r3 == false) goto L48;
        return r18;
    L48:
        throw new IllegalStateException("Check failed.".toString());
    L40:
        if (deleteDirectory(r12) == true) goto L43;
        r3 = false;
    L49:
        th = move-exception;
        r5.delete();
        if (deleteDirectory(r12) == true) goto L54;
        r3 = false;
    L54:
        if (r3 == false) goto L56;
        throw th;
    L56:
        throw new IllegalStateException("Check failed.".toString());
    L59:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L31:
        if (r5.delete() == true) goto L34;
        r6 = false;
        goto L35
    L61:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L63:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L65:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L19:
        if (r10.delete() == true) goto L22;
        r4 = false;
        goto L23
    L67:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r1.exists() == false) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 != true) goto L13;
        r2 = true;
        goto L15
    L7:
        if (r1.mkdirs() == true) goto L10;
        r8 = false;
        goto L11
    }

    static /* synthetic */ a preparePrivateWav$default(AuditoryBridgeAPIImpl r9, File r10, JSONArray r11, File r12, boolean r13, Function1 r14, Function0 r15, int r16, Object r17) {
        Function1<? super f, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        if ((r16 & 8) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r16 & 32) == 0) goto L10;
        r0 = $$Lambda$AuditoryBridgeAPIImpl$MrWA9ead1uPtSCXo56tVxkp99I0.INSTANCE;
    L10:
        return r9.preparePrivateWav(r10, r11, r12, r6, r7, r0);
    L5:
        r6 = r13;
        goto L7
    }

    private static final Unit preparePrivateWav$lambda$60() {
        return Unit.INSTANCE;
    }

    private static final b preparePrivateWav$lambda$62(JSONArray r1, File r2) {
        return INSTANCE.copyGrantedSourcesToPrivate(r1, r2);
    }

    private static final a preparePrivateWav$lambda$63(File r2, JSONArray r3, b r4, Function1 r5) {
        Function1<? super f, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        return INSTANCE.mergePcmWav(r2, r3, r4, r6);
    }

    private static final Unit preparePrivateWav$lambda$64(File r1, File r2) {
        INSTANCE.moveAtomically(r1, r2);
        return Unit.INSTANCE;
    }

    private static final Unit prepareUploadWav$lambda$20$lambda$18(AuditoryBridgeAPIImpl r1, String r2, f r3) {
        Intrinsics.checkNotNullParameter(r3, "adjustment");
        r1.reportWavDurationAdjustment(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit prepareUploadWav$lambda$20$lambda$19(Ref.LongRef r2, AuditoryBridgeAPIImpl r3, String r4) {
        r2.element = System.currentTimeMillis();
        if (r3.isCurrentAccountAllowed(r4) == false) goto L7;
        return Unit.INSTANCE;
    L7:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final Unit prepareUploadWav$lambda$22$lambda$21(WavPreparationFailure r2, com.obric.memorydata.middleware.api.logging.g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$errorTrace");
        if (r2 == null) goto L6;
        String r0 = r2.getStage();
        if (r0 == null) goto L6;
    L7:
        r3.a("failure_stage", r0);
        if (r2 == null) goto L10;
        int r1 = r2.getSegmentIndex();
    L11:
        r3.a("segment_index", Integer.valueOf(r1));
        if (r2 == null) goto L15;
        String r4 = r2.getReason();
        if (r4 == null) goto L15;
    L16:
        r3.a(InfoRequestQPSOptTraceLogger.REASON, r4);
        return Unit.INSTANCE;
    L15:
        r4 = "OPERATION_FAILED";
        goto L16
    L10:
        r1 = -1;
    L6:
        r0 = "MANIFEST_OR_OUTPUT";
        goto L7
    }

    private final File privateSourceDirectory(String r2, String r3) {
        return new File(accountPrivateSourceDirectory(r2), r3);
    }

    private final File privateSourceRootDirectory() {
        return new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), PRIVATE_SOURCE_DIRECTORY);
    }

    private static final Unit queryHotwords$lambda$11$lambda$10(String r2, com.obric.memorydata.middleware.api.logging.g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(Integer.valueOf(new JSONArray(r2).length()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r4) == false) goto L10;
        r4 = null;
    L10:
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        r3.a("hotwords_count", Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue()));
    L14:
        return Unit.INSTANCE;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final Unit queryHotwords$lambda$13$lambda$12(Throwable r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("error_type", r1.getClass().getSimpleName());
        return Unit.INSTANCE;
    }

    private static final Unit queryHotwords$lambda$6(com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a(InfoRequestQPSOptTraceLogger.REASON, "account_gate_closed");
        return Unit.INSTANCE;
    }

    private final String queryRecordDataInternal(long r17, long r19, int r21, int r22, boolean r23) {
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L5;
        AlwaysOnAudioQueryResult r2 = AlwaysOnAudioSource.INSTANCE.query(r17, r19);
        if (r2.isSuccess() == true) goto L16;
        AlwaysOnAudioError r1 = r2.getError();
        if (r1 == null) goto L11;
        String r4 = r1.name();
    L12:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        return errorResponse(r4);
    L11:
        r4 = null;
        goto L12
    L16:
        List<AlwaysOnAudioSegment> r3 = selectLatestQuerySegments$awareness_obricRelease(r2.getSegments());
        List<AlwaysOnAudioSegment> r5 = selectLatestQuerySegmentPage$awareness_obricRelease(r3, r21, r22);
        JSONArray r6 = new JSONArray();
        boolean r7 = true;
        if (r23 == false) goto L21;
        if (r21 == 0) goto L21;
        boolean r8 = false;
    L22:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(grantSegments(r5, r8), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r0.hasNext() == false) goto L41;
        Pair r9 = (Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin");
        AlwaysOnAudioSegment r10 = (AlwaysOnAudioSegment) ZeusTransformUtils.preCheckCast(r9.component1(), AlwaysOnAudioSegment.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9.component2(), String.class, "com.obric.memorydata.plugin");
        File r12 = new File(r10.getOriginalFilePath());
        if (r12.isFile() == true) goto L29;
        r12 = null;
    L29:
        if (r12 == null) goto L39;
        Long r13 = Long.valueOf(r12.lastModified());
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == true) goto L37;
        r13 = null;
    L37:
        if (r13 == null) goto L39;
        long r15 = r13.longValue();
    L40:
        r6.put(new JSONObject().put(KEY_START_MS, r10.getTimestampMillis()).put(KEY_DURATION_MS, r10.getDurationMillis()).put(KEY_END_MS, r10.getEndTimestampMillis()).put(KEY_READY_AT_MS, r15).put(KEY_SEGMENT_TOKEN, r11));
        goto L24
    L33:
        r14 = false;
    L39:
        r15 = -1;
        goto L40
    L41:
        JSONObject r16 = new JSONObject().put(KEY_CODE, 0).put(KEY_SEGMENTS, r6);
        if (r23 == false) goto L48;
        int r18 = r21 + r5.size();
        if (r18 < r3.size()) goto L47;
        r7 = false;
    L47:
        r16.put(KEY_HAS_MORE, r7);
        r16.put(KEY_NEXT_OFFSET, r18);
    L48:
        String r20 = r16.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "toString(...)");
        return r20;
    L21:
        r8 = true;
        goto L22
    L5:
        return errorResponse(ERROR_ACCOUNT_GATE_CLOSED);
    }

    private final String readFourCc(RandomAccessFile r2) {
        byte[] r1 = new byte[4];
        r2.readFully(r1);
        return new String(r1, Charsets.US_ASCII);
    }

    private final g readPcmFormat(RandomAccessFile r10, long r11) {
        boolean r12 = false;
        if (r11 < 16) goto L5;
        boolean r13 = true;
    L6:
        com.obric.memorydata.awareness.audio.h.a(r13, "FMT_CHUNK_TOO_SHORT");
        int r14 = readUInt16Le(r10);
        int r2 = readUInt16Le(r10);
        long r3 = readUInt32Le(r10);
        long r5 = readUInt32Le(r10);
        int r7 = readUInt16Le(r10);
        int r8 = readUInt16Le(r10);
        if (r14 != 1) goto L19;
        if (r2 <= 0) goto L19;
        if (r3 <= 0) goto L19;
        if (r8 <= 0) goto L19;
        if ((r8 % 8) != 0) goto L19;
        if (r7 != ((r2 * r8) / 8)) goto L19;
        if (r5 != (((long) r7) * r3)) goto L19;
        r12 = true;
    L19:
        com.obric.memorydata.awareness.audio.h.a(r12, "PCM_FORMAT_INVALID");
        return new g(r2, r3, r5, r7, r8);
    L5:
        r13 = false;
        goto L6
    }

    private final int readUInt16Le(RandomAccessFile r1) {
        return r1.readUnsignedByte() | (r1.readUnsignedByte() << 8);
    }

    private final long readUInt32Le(RandomAccessFile r5) {
        long r0 = (((long) r5.readUnsignedByte()) | (((long) r5.readUnsignedByte()) << 8)) | (((long) r5.readUnsignedByte()) << 16);
        return (((long) r5.readUnsignedByte()) << 24) | r0;
    }

    private static final void recordTaskRequestEvent$lambda$32$lambda$31(MemoryFrameDb r12, String r13, String r14, JSONObject r15) {
        AuditoryAsrTaskDao r1 = r12.getAuditoryAsrTaskDao();
        Intrinsics.checkNotNull(r13);
        AuditoryAsrTaskEntity r2 = r1.queryByTaskId(r13);
        if (r2 == null) goto L24;
        if (Intrinsics.areEqual(r2.getAccountScope(), r14) == false) goto L22;
        String r3 = r15.getString(KEY_REQUEST_STAGE);
        String r5 = r15.optString(KEY_LOG_ID);
        long r8 = r15.getLong(KEY_TRACE_END_AT_MS);
        String r7 = com.obric.memorydata.awareness.audio.e.f8528a.a(r2.getRequestLogIds(), r15);
        AuditoryAsrTaskDao r0 = r12.getAuditoryAsrTaskDao();
        String r6 = "";
        if (Intrinsics.areEqual(r3, TRACE_STAGE_ASR_SUBMIT) == false) goto L9;
        String r4 = r5;
    L10:
        Intrinsics.checkNotNull(r4);
        if (Intrinsics.areEqual(r3, TRACE_STAGE_ASR_QUERY) == false) goto L13;
        r6 = r5;
    L13:
        Intrinsics.checkNotNull(r6);
        int r9 = r0.updateRequestIds(r13, r14, r4, r6, r7, r8);
        boolean r10 = true;
        if (r9 == 1) goto L17;
        r10 = false;
    L17:
        if (r10 == false) goto L20;
        return;
    L20:
        throw new IllegalStateException("Check failed.".toString());
    L9:
        r4 = "";
        goto L10
    L22:
        throw new IllegalStateException("Check failed.".toString());
    L24:
        throw new IllegalStateException(ERROR_TASK_NOT_FOUND.toString());
    }

    private final void reportWavDurationAdjustment(String r8, f r9) {
        o r7 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r6 = new com.obric.memorydata.middleware.api.logging.e(null, r8, "wav_prepare", 1, null);
        com.obric.memorydata.middleware.api.logging.g r10 = new com.obric.memorydata.middleware.api.logging.g();
        r10.a("segment_index", Integer.valueOf(r9.a()));
        r10.a("declared_duration_ms", Long.valueOf(r9.b()));
        r10.a("actual_duration_ms", Long.valueOf(r9.c()));
        r10.a("duration_delta_ms", Long.valueOf(r9.c() - r9.b()));
        r7.a(WARNING_WAV_DURATION_ADJUSTED, "听觉音频声明时长与实际 WAV 不一致，已按实际时长修正", r6, r10.a());
    }

    private final c resolveSegmentGrant(String r3, long r4, long r6, long r8, long r10) {
        Object r2 = segmentGrantLock;
        monitor-enter(r2);
        c r5 = (c) ZeusTransformUtils.preCheckCast(segmentGrants.get(r3), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        monitor-exit(r2);
        if (r5 == null) goto L22;
        if (r5.b() == r4) goto L10;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L20;
        return r5;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        if (r5.c() != r6) goto L16;
        if (r5.d() != r8) goto L16;
        if (r5.e() != r10) goto L16;
        r7 = true;
        goto L17
    L22:
        throw new IllegalStateException(ERROR_SEGMENT_GRANT_INVALID.toString());
    L23:
        th = move-exception;
        throw th;
    }

    private final void revokeSegmentGrants(Set<String> r5) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Object r6 = segmentGrantLock;
        monitor-enter(r6);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        LinkedHashMap<String, c> r0 = segmentGrants;     // Catch: Throwable -> L11
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L11
    L6:
        if (r8.hasNext() == false) goto L8;
        r0.remove((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r6);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private final String safeSourceFileName(File r8) {
        String r7 = r8.getName();
        Intrinsics.checkNotNull(r7);
        boolean r1 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        boolean r9 = false;
    L9:
        if (r9 == false) goto L21;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '/', false, 2, null) == false) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L19;
        return r7;
    L19:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L13:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), '\\', false, 2, null) == true) goto L15;
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (SetsKt.setOf(new String[]{".", ".."}).contains(r7) == true) goto L7;
        r9 = true;
        goto L9
    }

    private final String sha256(File r13) {
        MessageDigest r12 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r13), InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        BufferedInputStream r0 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r14, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        byte[] r1 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r3 = r0.read(r1);     // Catch: Throwable -> L10
        if (r3 <= 0) goto L7;
        r12.update(r1, 0, r3);     // Catch: Throwable -> L10
        goto L4
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r14, null);
        byte[] r4 = r12.digest();
        Intrinsics.checkNotNullExpressionValue(r4, "digest(...)");
        return ArraysKt.joinToString$default(r4, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$AuditoryBridgeAPIImpl$O23RAJzPNOwosAzuYQ8Bwkm0_kM.INSTANCE, 30, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    private final String sha256(String r11) {
        MessageDigest r10 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        byte[] r12 = r11.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
        byte[] r1 = r10.digest(r12);
        Intrinsics.checkNotNullExpressionValue(r1, "digest(...)");
        return ArraysKt.joinToString$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$AuditoryBridgeAPIImpl$P_lsL0S6W1lrhye_Ln7tdYhD4.INSTANCE, 30, null);
    }

    private static final CharSequence sha256$lambda$91(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence sha256$lambda$92(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final File uploadWavDirectory() {
        File r3 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), UPLOAD_DIRECTORY);
        if (r3.exists() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return r3;
    L12:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r3.mkdirs() == true) goto L8;
        r0 = false;
        goto L9
    }

    private final File uploadWavFile(String r3) {
        return new File(uploadWavDirectory(), r3 + WAV_SUFFIX);
    }

    private final JSONArray writeMergedWav(File r23, JSONArray r24, h r25) {
        JSONArray r1 = new JSONArray();
        String r5 = "com.obric.memorydata.plugin";
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r23), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        BufferedOutputStream r3 = (BufferedOutputStream) ZeusTransformUtils.preCheckCast(r2, BufferedOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        INSTANCE.writeWavHeader(r3, r25.a(), r25.c());     // Catch: Throwable -> L16
        int r6 = 0;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r25.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L16
        long r7 = 0;
    L5:
        if (r4.hasNext() == false) goto L13;
        Object r9 = r4.next();     // Catch: Throwable -> L16
        int r10 = r6 + 1;     // Catch: Throwable -> L16
        if (r6 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L16
    L9:
        i r11 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, r5);     // Catch: Throwable -> L16
        if (r6 <= 0) goto L12;
        long r12 = r25.a().c() * 3;     // Catch: Throwable -> L16
        INSTANCE.writeZeros(r3, r12);     // Catch: Throwable -> L16
        r7 = r7 + r12;     // Catch: Throwable -> L16
    L12:
        long r13 = (r7 * 1000) / r25.a().c();     // Catch: Throwable -> L16
        INSTANCE.copyWavData(r11, r3);     // Catch: Throwable -> L16
        long r8 = r7 + r11.d();     // Catch: Throwable -> L16
        long r14 = (r8 * 1000) / r25.a().c();     // Catch: Throwable -> L16
        JSONObject r15 = r24.getJSONObject(r6);     // Catch: Throwable -> L16
        BufferedOutputStream r16 = r3;
        Iterator r17 = r4;
        long r18 = r15.getLong(KEY_START_MS);     // Catch: Throwable -> L16
        long r19 = (r11.d() * 1000) / r11.b().c();     // Catch: Throwable -> L16
        String r110 = r5;
        r1.put(new JSONObject().put(KEY_SOURCE_START_MS, r18).put(KEY_SOURCE_END_MS, Math.addExact(r18, r19)).put(KEY_READY_AT_MS, r15.optLong(KEY_READY_AT_MS, -1)).put(KEY_AUDIO_START_MS, r13).put(KEY_AUDIO_END_MS, r14));     // Catch: Throwable -> L16
        r7 = r8;
        r6 = r10;
        r3 = r16;
        r4 = r17;
        r5 = r110;
        goto L5
    L13:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r2, null);
        return r1;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private final void writeUInt16Le(BufferedOutputStream r1, int r2) {
        r1.write(r2 & 255);
        r1.write((r2 >>> 8) & 255);
    }

    private final void writeUInt32Le(BufferedOutputStream r6, long r7) {
        int r0 = 0;
        if (0 <= r7) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L14;
    L10:
        if (r0 >= 4) goto L12;
        r6.write((int) ((r7 >>> (r0 * 8)) & 255));
        r0 = r0 + 1;
        goto L10
    L12:
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r7 > (((long) (-1)) & 4294967295L)) goto L7;
        r5 = true;
        goto L8
    }

    private final void writeWavHeader(BufferedOutputStream r7, g r8, long r9) {
        byte[] r0 = "RIFF".getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");
        r7.write(r0);
        writeUInt32Le(r7, (WAV_HEADER_SIZE + r9) - 8);
        byte[] r1 = "WAVEfmt ".getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(r1, "getBytes(...)");
        r7.write(r1);
        writeUInt32Le(r7, 16);
        writeUInt16Le(r7, 1);
        writeUInt16Le(r7, r8.a());
        writeUInt32Le(r7, r8.b());
        writeUInt32Le(r7, r8.c());
        writeUInt16Le(r7, r8.d());
        writeUInt16Le(r7, r8.e());
        byte[] r10 = "data".getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(r10, "getBytes(...)");
        r7.write(r10);
        writeUInt32Le(r7, r9);
    }

    private final void writeZeros(BufferedOutputStream r4, long r5) {
        byte[] r0 = new byte[8192];
    L4:
        if (r5 <= 0) goto L6;
        int r1 = (int) Math.min(8192, r5);
        r4.write(r0, 0, r1);
        r5 = r5 - ((long) r1);
        goto L4
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public int cleanupUploadBundles(long r18) {
        String r3 = "getName(...)";
        if (r18 >= 0) goto L34;
        return -1;
    L34:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L27
        AuditoryBridgeAPIImpl r6 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        AuditoryAsrTaskDao r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao();     // Catch: Throwable -> L27
        int r8 = r6.cleanupExpiredTerminalTasks(r7.queryExpiredTerminal(r18, 50));     // Catch: Throwable -> L27
        HashSet r9 = CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast(r7.queryAllTaskIds(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        File[] r10 = r6.uploadWavDirectory().listFiles();     // Catch: Throwable -> L27
        if (r10 != null) goto L8;
        r10 = new File[0];     // Catch: Throwable -> L27
    L8:
        int r11 = r10.length;     // Catch: Throwable -> L27
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L25;
        File r13 = r10[r12];     // Catch: Throwable -> L27
        String r14 = r13.getName();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r14, r3);     // Catch: Throwable -> L27
        String r15 = StringsKt.removeSuffix(r14, (CharSequence) ZeusTransformUtils.preCheckCast(WAV_SUFFIX, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        if (r13.isFile() == false) goto L23;
        String r16 = r13.getName();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r16, r3);     // Catch: Throwable -> L27
        String r17 = r3;
        if (StringsKt.endsWith$default(r16, WAV_SUFFIX, false, 2, null) == false) goto L24;
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L24;
        if (r9.contains(r15) == true) goto L24;
        if (r13.lastModified() > r18) goto L24;
        if (r13.delete() == false) goto L24;
        r8 = r8 + 1;     // Catch: Throwable -> L27
    L24:
        r12 = r12 + 1;     // Catch: Throwable -> L27
        r3 = r17;
        goto L9
    L23:
        r17 = r3;
        goto L24
    L25:
        Object r0 = Result.m1421constructorimpl(Integer.valueOf(r8 + r6.cleanupPrivateSourceDirectories(r18, (Set) ZeusTransformUtils.preCheckCast(r9, Set.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L27
    L30:
        if (Result.m1427isFailureimpl(r0) == false) goto L33;
        r0 = -1;
    L33:
        return ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue();
    L27:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean clearAccountData(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "accountScope");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return false;
    L5:
        hotwordsCache.b(r10);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L32
        AuditoryBridgeAPIImpl r9 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        final MemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();     // Catch: Throwable -> L32
        List<String> r3 = r1.getAuditoryAsrTaskDao().queryTaskIdsByAccount(r10);     // Catch: Throwable -> L32
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L32
        boolean r5 = true;
    L7:
        boolean r6 = true;
    L9:
        if (r4.hasNext() == false) goto L15;
        if (r9.deleteUploadBundle((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L14;
        if (r6 == true) goto L7;
    L14:
        r6 = false;
        goto L9
    L15:
        boolean r11 = r9.deleteDirectory(r9.accountPrivateSourceDirectory(r10));     // Catch: Throwable -> L32
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L32
    L16:
        boolean r8 = true;
    L18:
        if (r7.hasNext() == false) goto L24;
        if (com.obric.memorydata.awareness.audio.c.f8523a.b(r10, (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L23;
        if (r8 == true) goto L16;
    L23:
        r8 = false;
        goto L18
    L24:
        r1.runInTransaction(new $$Lambda$AuditoryBridgeAPIImpl$Ro0xA4P7oRiRv7cKcDQuOYQ5LF0(r1, r10));     // Catch: Throwable -> L32
        if (r6 == false) goto L29;
        if (r11 == false) goto L29;
        if (r8 == false) goto L29;
    L30:
        Object r12 = Result.m1421constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L32
    L35:
        if (Result.m1427isFailureimpl(r12) == false) goto L38;
        r12 = false;
    L38:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L29:
        r5 = false;
    L32:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L35
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [T, java.util.List] */
    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String commitL0Result(final String r21, final String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "taskId");
        Intrinsics.checkNotNullParameter(r22, "accountScope");
        Intrinsics.checkNotNullParameter(r23, "resultJson");
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L37;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L37;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L28
        final AuditoryBridgeAPIImpl r15 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r15.isCurrentAccountAllowed(r22) == false) goto L27;
        final JSONObject r7 = new JSONObject(r23);     // Catch: Throwable -> L28
        JSONArray r0 = r7.getJSONArray(KEY_RAW_ROWS);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r0, "getJSONArray(...)");     // Catch: Throwable -> L28
        final List<RawObservationEntity> r12 = r15.decodeRawRows(r0);     // Catch: Throwable -> L28
        JSONArray r1 = r7.optJSONArray(KEY_EMBEDDINGS);     // Catch: Throwable -> L28
        if (r1 != null) goto L12;
        r1 = new JSONArray();     // Catch: Throwable -> L28
    L12:
        final JSONArray r8 = r1;
        final JSONObject r9 = r15.decodeValidationWarnings(r7);     // Catch: Throwable -> L28
        final MemoryFrameDb r11 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();     // Catch: Throwable -> L28
        final Ref.IntRef r10 = new Ref.IntRef();     // Catch: Throwable -> L28
        final Ref.ObjectRef r6 = new Ref.ObjectRef();     // Catch: Throwable -> L28
        r6.element = CollectionsKt.emptyList();     // Catch: Throwable -> L28
        if (com.obric.memorydata.awareness.audio.c.f8523a.a() == true) goto L15;
    L17:
        boolean r16 = false;
    L18:
        final boolean r17 = com.obric.memorydata.awareness.audio.c.f8523a.a(r22, r21, r23);     // Catch: Throwable -> L28
        if (r16 == false) goto L21;
    L25:
        final boolean r13 = r16;
        r11.runInTransaction(new $$Lambda$AuditoryBridgeAPIImpl$DKfEpq43ikGqNTHm8WdeSmDiR2I(r11, r21, r22, r12, r10, r15, r7, r8, r9, r17, r13, r6));     // Catch: Throwable -> L28
        r15.logCommittedRawSpans(r21, (List) ZeusTransformUtils.preCheckCast(r6.element, List.class, "com.obric.memorydata.plugin"), r12);     // Catch: Throwable -> L28
        Object r3 = Result.m1421constructorimpl(new JSONObject().put(KEY_CODE, 0).put(KEY_RAW_COUNT, r12.size()).put(KEY_EMBEDDING_COUNT, r10.element).toString());     // Catch: Throwable -> L28
    L31:
        if (Result.m1424exceptionOrNullimpl(r3) == null) goto L35;
        r3 = INSTANCE.errorResponse(ERROR_COMMIT_FAILED);
    L35:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L21:
        if (r15.deleteUploadBundle(r21) == true) goto L25;
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L28
    L15:
        if (r15.privateSourceDirectory(r22, r21).isDirectory() == false) goto L17;
        r16 = true;
        goto L18
    L27:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L37:
        return errorResponse(ERROR_RESULT_INVALID);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public int countTasks(String r3) {
        Intrinsics.checkNotNullParameter(r3, "accountScope");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        return 0;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        AuditoryBridgeAPIImpl r2 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r4 = Result.m1421constructorimpl(Integer.valueOf(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao().countActiveByAccount(r3)));     // Catch: Throwable -> L8
    L11:
        if (Result.m1427isFailureimpl(r4) == false) goto L14;
        r4 = -1;
    L14:
        return ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean deleteUploadBundle(String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        return false;
    L5:
        File r0 = uploadWavFile(r5);
        if (r0.exists() == true) goto L8;
    L11:
        boolean r1 = true;
    L12:
        boolean r4 = deletePrivateSourceDirectories(r5);
        if (r1 == false) goto L17;
        if (r4 == true) goto L16;
        return false;
    L16:
        return true;
    L17:
        return false;
    L8:
        if (r0.delete() == true) goto L11;
        r1 = false;
        goto L12
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String finalizePendingTaskTelemetry(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "accountScope");
        if (r9 < 0) goto L27;
        if (isCurrentAccountAllowed(r8) == false) goto L27;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        AuditoryBridgeAPIImpl r7 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        JSONArray r2 = new JSONArray();     // Catch: Throwable -> L18
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao().queryUnreportedTerminal(r8, 50), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L18
    L10:
        if (r3.hasNext() == false) goto L16;
        JSONObject r6 = new JSONObject(r7.finalizeTaskTelemetry(((AuditoryAsrTaskEntity) ZeusTransformUtils.preCheckCast(r3.next(), AuditoryAsrTaskEntity.class, "com.obric.memorydata.plugin")).getTaskId(), r8, r9));     // Catch: Throwable -> L18
        if (r6.optInt(KEY_CODE, -1) != 0) goto L10;
        if (r6.optBoolean(KEY_SHOULD_REPORT, false) == false) goto L10;
        r2.put(r6.getJSONObject(KEY_EVENT_PAYLOAD));     // Catch: Throwable -> L18
        goto L10
    L16:
        Object r10 = Result.m1421constructorimpl(new JSONObject().put(KEY_CODE, 0).put(KEY_EVENTS, r2).toString());     // Catch: Throwable -> L18
    L21:
        if (Result.m1424exceptionOrNullimpl(r10) == null) goto L25;
        r10 = INSTANCE.errorResponse(ERROR_TELEMETRY_FINALIZE_FAILED);
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L27:
        return errorResponse(ERROR_RESULT_INVALID);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String finalizeTaskTelemetry(String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "accountScope");
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L26;
        if (r6 < 0) goto L26;
        if (isCurrentAccountAllowed(r5) == false) goto L26;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        JSONObject r3 = ((AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin")).finalizeTaskTelemetryTransaction(r4, r5, r6);     // Catch: Throwable -> L17
        boolean r7 = false;
        JSONObject r8 = new JSONObject().put(KEY_CODE, 0);     // Catch: Throwable -> L17
        if (r3 == null) goto L12;
        r7 = true;
    L12:
        JSONObject r9 = r8.put(KEY_SHOULD_REPORT, r7);     // Catch: Throwable -> L17
        if (r3 == null) goto L15;
        r9.put(KEY_EVENT_PAYLOAD, r3);     // Catch: Throwable -> L17
    L15:
        Object r10 = Result.m1421constructorimpl(r9.toString());     // Catch: Throwable -> L17
    L20:
        if (Result.m1424exceptionOrNullimpl(r10) == null) goto L24;
        r10 = INSTANCE.errorResponse(ERROR_TELEMETRY_FINALIZE_FAILED);
    L24:
        return (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L26:
        return errorResponse(ERROR_RESULT_INVALID);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean finishTask(String r13, String r14, String r15, String r16, String r17, long r18) {
        Intrinsics.checkNotNullParameter(r13, "taskId");
        Intrinsics.checkNotNullParameter(r14, "accountScope");
        Intrinsics.checkNotNullParameter(r15, "expectedStatus");
        Intrinsics.checkNotNullParameter(r16, "terminalStatus");
        Intrinsics.checkNotNullParameter(r17, "errorCode");
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L44:
        return false;
    L5:
        if (isCurrentAccountAllowed(r14) == false) goto L44;
        if (ACTIVE_TASK_STATUSES.contains(r15) == false) goto L44;
        if (TERMINAL_TASK_STATUSES.contains(r16) == false) goto L44;
        if (r17.length() > 80) goto L44;
        if (r18 < 0) goto L44;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L37
        AuditoryBridgeAPIImpl r0 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        AuditoryAsrTaskDao r6 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao();     // Catch: Throwable -> L37
        boolean r11 = true;
        if (com.obric.memorydata.awareness.audio.c.f8523a.a() == true) goto L19;
    L21:
        boolean r7 = false;
    L22:
        if (r7 == false) goto L24;
    L28:
        if (r7 == false) goto L30;
        String r1 = EVIDENCE_COMPLETE;
    L32:
        if (r6.finish(r13, r14, r15, r16, r17, r1, r18) == 1) goto L35;
        r11 = false;
    L35:
        Object r2 = Result.m1421constructorimpl(Boolean.valueOf(r11));     // Catch: Throwable -> L37
    L40:
        if (Result.m1427isFailureimpl(r2) == false) goto L43;
        r2 = false;
    L43:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L30:
        r1 = EVIDENCE_PARTIAL_LOW_STORAGE;
        goto L32
    L24:
        if (r0.deleteUploadBundle(r13) == true) goto L28;
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L37
    L19:
        if (r0.privateSourceDirectory(r14, r13).isDirectory() == false) goto L21;
        r7 = true;
    L37:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L40
    }

    public final String formatTimeForTest$awareness_obricRelease(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "timezoneId");
        TimeZone r5 = TimeZone.getTimeZone(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "getTimeZone(...)");
        return formatTime(r2, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String getCachedHotwords(String r2) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        if (isCurrentAccountAllowed(r2) == true) goto L7;
        return "[]";
    L7:
        return hotwordsCache.a(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean markTaskRetry(String r11, String r12, String r13, int r14, String r15, long r16) {
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r12, "accountScope");
        Intrinsics.checkNotNullParameter(r13, "expectedStatus");
        Intrinsics.checkNotNullParameter(r15, "errorCode");
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L30:
        return false;
    L5:
        if (isCurrentAccountAllowed(r12) == false) goto L30;
        if (ACTIVE_TASK_STATUSES.contains(r13) == false) goto L30;
        if (r14 < 0) goto L30;
        if (r16 < 0) goto L30;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L30;
        if (r15.length() > 80) goto L30;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L23
        AuditoryBridgeAPIImpl r0 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        boolean r1 = true;
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao().markRetry(r11, r12, r13, r14, r15, r16) == 1) goto L21;
        r1 = false;
    L21:
        Object r2 = Result.m1421constructorimpl(Boolean.valueOf(r1));     // Catch: Throwable -> L23
    L26:
        if (Result.m1427isFailureimpl(r2) == false) goto L29;
        r2 = false;
    L29:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L23:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public final JSONObject mergePcmWavForTest$awareness_obricRelease(File r24, List<e> r25, File r26, boolean r27, Function1<? super d, Unit> r28, Function0<Unit> r29) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        final Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r29, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r24, "output");
        Intrinsics.checkNotNullParameter(r0, KEY_SEGMENTS);
        Intrinsics.checkNotNullParameter(r26, "privateSourceDirectory");
        Intrinsics.checkNotNullParameter(r1, "onDurationAdjusted");
        Intrinsics.checkNotNullParameter(r9, "afterCopy");
        JSONArray r5 = new JSONArray();
        Object r2 = segmentGrantLock;
        monitor-enter(r2);
        segmentGrants.clear();     // Catch: Throwable -> L25
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L25
        int r7 = 0;
    L6:
        if (r3.hasNext() == false) goto L21;
        Object r8 = r3.next();     // Catch: Throwable -> L25
        int r10 = r7 + 1;     // Catch: Throwable -> L25
        if (r7 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L25
    L10:
        e r11 = (e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        String r12 = "test-" + r7;     // Catch: Throwable -> L25
        Long r13 = Long.valueOf(r11.a().lastModified());     // Catch: Throwable -> L25
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L13;
        boolean r14 = true;
    L14:
        if (r14 == true) goto L17;
        r13 = null;
    L17:
        if (r13 == null) goto L19;
        long r15 = r13.longValue();     // Catch: Throwable -> L25
    L20:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(segmentGrants, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        String r17 = r11.a().getAbsolutePath();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r17, "getAbsolutePath(...)");     // Catch: Throwable -> L25
        r16.put(r12, new c(r17, r11.b(), r11.b() + r11.c(), r11.c(), r15));     // Catch: Throwable -> L25
        r5.put(new JSONObject().put(KEY_START_MS, r11.b()).put(KEY_END_MS, r11.b() + r11.c()).put(KEY_DURATION_MS, r11.c()).put(KEY_READY_AT_MS, r15).put(KEY_SEGMENT_TOKEN, r12));     // Catch: Throwable -> L25
        r3 = r3;
        r7 = r10;
        goto L6
    L19:
        r15 = -1;
        goto L20
    L13:
        r14 = false;
        goto L14
    L21:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r2);
        return preparePrivateWav(r24, r5, r26, r27, new $$Lambda$AuditoryBridgeAPIImpl$jZwogk_4S8CscLTHe6TspdnGcdA(r1), r9).a();
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean persistTaskAndCursor(String r13, final long r14) {
        Intrinsics.checkNotNullParameter(r13, "taskJson");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        AuditoryBridgeAPIImpl r12 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        JSONObject r3 = new JSONObject(r13);     // Catch: Throwable -> L20
        final AuditoryAsrTaskEntity r5 = r12.decodeTask(r3);     // Catch: Throwable -> L20
        if (r12.isCurrentAccountAllowed(r5.getAccountScope()) == false) goto L19;
        final long r10 = r3.getLong(KEY_LAST_QUERY_END_MS);     // Catch: Throwable -> L20
        final long r8 = r3.getLong(KEY_LAST_FILE_END_MS);     // Catch: Throwable -> L20
        if (r10 >= r8) goto L9;
    L13:
        boolean r15 = false;
    L14:
        if (r15 == false) goto L17;
        final MemoryFrameDb r16 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();     // Catch: Throwable -> L20
        r16.runInTransaction(new $$Lambda$AuditoryBridgeAPIImpl$BNiyzvgAXeszi7uuU8oil3bFJg(r16, r5, r14, r8, r10));     // Catch: Throwable -> L20
        Object r17 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L20
    L23:
        if (Result.m1427isFailureimpl(r17) == false) goto L26;
        r17 = false;
    L26:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L17:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L20
    L9:
        if (r8 < 0) goto L13;
        if (r14 < 0) goto L13;
        r15 = true;
        goto L14
    L19:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String prepareUploadWav(final String r18, final String r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "taskId");
        Intrinsics.checkNotNullParameter(r19, "accountScope");
        Intrinsics.checkNotNullParameter(r20, "manifestJson");
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        return errorResponse(ERROR_INVALID_TASK_ID);
    L7:
        if (isCurrentAccountAllowed(r19) == false) goto L9;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L20
        final AuditoryBridgeAPIImpl r0 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        JSONArray r9 = new JSONObject(r20).getJSONArray(KEY_SEGMENTS);     // Catch: Throwable -> L20
        int r3 = r9.length();     // Catch: Throwable -> L20
        boolean r5 = true;
        if (1 <= r3) goto L13;
    L15:
        r5 = false;
    L16:
        if (r5 == false) goto L19;
        File r6 = r0.uploadWavFile(r18);     // Catch: Throwable -> L20
        File r10 = r0.privateSourceDirectory(r19, r18);     // Catch: Throwable -> L20
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L20
        final Ref.LongRef r7 = new Ref.LongRef();     // Catch: Throwable -> L20
        r7.element = r14;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L20
        a r1 = r0.preparePrivateWav(r6, r9, r10, com.obric.memorydata.awareness.audio.c.f8523a.b(), new $$Lambda$AuditoryBridgeAPIImpl$Woj1pEZIlTEnN2K58ZRiBiOUg(r0, r18), new $$Lambda$AuditoryBridgeAPIImpl$yeVS7fXTfQ0nEQHytHaNfuTX1d4(r7, r0, r19));     // Catch: Throwable -> L20
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L20
        r0.revokeSegmentGrants(r1.b());     // Catch: Throwable -> L20
        Object r2 = Result.m1421constructorimpl(new JSONObject().put(KEY_CODE, 0).put(KEY_AUDIO_REF, r6.getName()).put(KEY_AUDIO_SHA256, r0.sha256(r6)).put(KEY_MANIFEST, r1.a()).put(KEY_TIMING, new JSONObject().put(KEY_COPY_STARTED_AT_MS, r14).put(KEY_COPY_FINISHED_AT_MS, r7.element).put(KEY_MERGE_FINISHED_AT_MS, r8)).toString());     // Catch: Throwable -> L20
    L22:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r2);
        if (r11 == null) goto L31;
        if (ZeusTransformUtils.instanceOf(r11, WavPreparationFailure.class) == false) goto L28;
        WavPreparationFailure r12 = (WavPreparationFailure) ZeusTransformUtils.preCheckCast(r11, WavPreparationFailure.class, "com.obric.memorydata.plugin");
    L29:
        final WavPreparationFailure r13 = r12;
        o.a((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin"), "听觉音频准备失败，整组保留待后续重试", "wav_prepare_failed", ERROR_PREPARE_WAV_FAILED, null, new com.obric.memorydata.middleware.api.logging.e(null, r18, "wav_prepare", 1, null), new $$Lambda$AuditoryBridgeAPIImpl$pGuXy7AXIP_1p6OB2fD4BDrukc(r13), 8, null);
        r2 = INSTANCE.errorResponse(ERROR_PREPARE_WAV_FAILED);
        goto L31
    L28:
        r12 = null;
    L31:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L19:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L20
    L13:
        if (r3 >= 101) goto L15;
    L20:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L9:
        return errorResponse(ERROR_ACCOUNT_GATE_CLOSED);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String queryHotwords(String r23, int r24) {
        Intrinsics.checkNotNullParameter(r23, "accountScope");
        if (isCurrentAccountAllowed(r23) == true) goto L36;
        hotwordsCache.b(r23);
        o.a(logger, "眼镜热词查询已停止", "hotwords_query_stopped", new com.obric.memorydata.middleware.api.logging.e(null, null, "query_hotwords", 3, null), $$Lambda$AuditoryBridgeAPIImpl$QnQ_OPAQ5JMldQgiY8AV7BKpO4.INSTANCE, null, 16, null);
        return "[]";
    L36:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        AuditoryBridgeAPIImpl r1 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        String r2 = (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.b.f12829a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r24).getData(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r2 != null) goto L11;
    L16:
        r2 = "[]";
    L17:
        Object r3 = Result.m1421constructorimpl(r2);     // Catch: Throwable -> L19
    L24:
        final Throwable r5 = Result.m1424exceptionOrNullimpl(r3);
        if (r5 != null) goto L27;
        final String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        o.a(logger, "眼镜热词查询完成", "hotwords_query_finished", new com.obric.memorydata.middleware.api.logging.e(null, null, "query_hotwords", 3, null), new $$Lambda$AuditoryBridgeAPIImpl$XqFZ37HeOUOXfeOy4KjOmquWaWY(r4), null, 16, null);
    L29:
        if (isCurrentAccountAllowed(r23) == true) goto L32;
        hotwordsCache.b(r23);
        return "[]";
    L32:
        hotwordsCache.a(r23, r4);
        return r4;
    L27:
        o.a(logger, "眼镜热词查询失败", "hotwords_query_failed", "memory_api_failed", null, new com.obric.memorydata.middleware.api.logging.e(null, null, "query_hotwords", 3, null), new $$Lambda$AuditoryBridgeAPIImpl$xoBkRc700172QverehQRXQsZLrA(r5), 8, null);
        r4 = "[]";
        goto L29
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
    L19:
        th = th;
    L23:
        Result.Companion r6 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L21:
        th = th;
        goto L23
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String queryRecordData(long r9, long r11) {
        return queryRecordDataInternal(r9, r11, 0, 10000, false);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String queryRecordDataPage(long r10, long r12, int r14, int r15) {
        boolean r0 = true;
        if (r14 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L19;
        if (1 <= r15) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == false) goto L19;
        return queryRecordDataInternal(r10, r12, r14, r15, true);
    L11:
        if (r15 >= 1001) goto L13;
    L19:
        return errorResponse(ERROR_QUERY_PAGE_INVALID);
    L5:
        if (r14 >= 10000) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean recordTaskRequestEvent(String r8) {
        Intrinsics.checkNotNullParameter(r8, "eventJson");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        AuditoryBridgeAPIImpl r7 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        final JSONObject r3 = new JSONObject(r8);     // Catch: Throwable -> L21
        final String r9 = r3.getString(KEY_TASK_ID);     // Catch: Throwable -> L21
        final String r4 = r3.getString(KEY_ACCOUNT_SCOPE);     // Catch: Throwable -> L21
        Regex r5 = TASK_ID_REGEX;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L21
        if (r5.matches((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L21
        if (r7.isCurrentAccountAllowed(r4) == false) goto L8;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L20;
        if (r3.getInt("v") != 2) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == false) goto L18;
        final MemoryFrameDb r12 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();     // Catch: Throwable -> L21
        r12.runInTransaction(new $$Lambda$AuditoryBridgeAPIImpl$jrWeX6T_74dICFqYzAJAhmYLLeg(r12, r9, r4, r3));     // Catch: Throwable -> L21
        Object r13 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L21
    L24:
        if (Result.m1427isFailureimpl(r13) == false) goto L27;
        r13 = false;
    L27:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L21
    L14:
        r11 = false;
        goto L15
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L21
    L8:
        r10 = false;
    L21:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean removeScheduledTask(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskRequestId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L14;
        return false;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        AuditoryBridgeAPIImpl r3 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().e(r4);     // Catch: Throwable -> L7
        Object r5 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r5) == false) goto L13;
        r5 = false;
    L13:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final List<AlwaysOnAudioSegment> selectLatestQuerySegmentPage$awareness_obricRelease(List<AlwaysOnAudioSegment> r2, int r3, int r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "selectedSegments");
        return CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), r3), Iterable.class, "com.obric.memorydata.plugin"), r4);
    }

    public final List<AlwaysOnAudioSegment> selectLatestQuerySegments$awareness_obricRelease(List<AlwaysOnAudioSegment> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, KEY_SEGMENTS);
        return CollectionsKt.takeLast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{AuditoryBridgeAPIImpl$selectLatestQuerySegments$1.INSTANCE, AuditoryBridgeAPIImpl$selectLatestQuerySegments$2.INSTANCE, AuditoryBridgeAPIImpl$selectLatestQuerySegments$3.INSTANCE})), 10000);
    }

    public final com.obric.memorydata.awareness.audio.e.a terminalDecision$awareness_obricRelease(AuditoryAsrTaskEntity r10, List<Long> r11, List<RawObservationEntity> r12, long r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<RawObservationEntity> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "task");
        Intrinsics.checkNotNullParameter(r14, "rawIds");
        Intrinsics.checkNotNullParameter(r15, "raws");
        if (Intrinsics.areEqual(r10.getStatus(), RawObservationEntity.STATE_FAILED) == false) goto L7;
        return failedDecision(r10, r14.size());
    L7:
        if (Intrinsics.areEqual(r10.getStatus(), "DONE") == false) goto L13;
        if (r14.isEmpty() == false) goto L13;
        return new com.obric.memorydata.awareness.audio.e.a(2, TRACE_RESULT_SUCCESS_NO_ASR, "NONE", 0, 0);
    L13:
        if (Intrinsics.areEqual(r10.getStatus(), "DONE") == false) goto L31;
        if (r15.size() != r14.size()) goto L31;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L19;
    L21:
        Iterator r1 = r0.iterator();
    L23:
        if (r1.hasNext() == false) goto L27;
        RawObservationEntity r2 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r1.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (RAW_TERMINAL_STATES.contains(r2.getState()) == true) goto L23;
        r3 = false;
    L27:
        if (r3 == false) goto L31;
        return completedL1Decision(r10, r14.size(), r15);
    L19:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L21;
    L31:
        if (r10.getCreatedAt() <= (r13 - TASK_RETENTION_MS)) goto L38;
        return null;
    L38:
        return expiredDecision(r10, r14.size());
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean transitionTask(String r11, String r12, String r13, String r14, String r15, long r16) {
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r12, "accountScope");
        Intrinsics.checkNotNullParameter(r13, "expectedStatus");
        Intrinsics.checkNotNullParameter(r14, "targetStatus");
        if (TASK_ID_REGEX.matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L27:
        return false;
    L5:
        if (isCurrentAccountAllowed(r12) == false) goto L27;
        Set<String> r5 = ACTIVE_TASK_STATUSES;
        if (r5.contains(r13) == false) goto L27;
        if (r5.contains(r14) == false) goto L27;
        if (r16 < 0) goto L27;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L20
        AuditoryBridgeAPIImpl r0 = (AuditoryBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, AuditoryBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        boolean r1 = true;
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao().transition(r11, r12, r13, r14, r15, r16) == 1) goto L18;
        r1 = false;
    L18:
        Object r2 = Result.m1421constructorimpl(Boolean.valueOf(r1));     // Catch: Throwable -> L20
    L23:
        if (Result.m1427isFailureimpl(r2) == false) goto L26;
        r2 = false;
    L26:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L20:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
