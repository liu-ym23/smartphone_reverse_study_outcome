package com.obric.memorydata.database.index;

import android.database.sqlite.SQLiteException;
import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.entity.bh;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0018\b\u0000\u0018\u0000 \u009e\u00012\u00020\u0001:\u0012\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001BM\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014¢\u0006\u0002\u0010\u0015J:\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ0\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ&\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00172\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJa\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u0012\u001a\u00020\b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b,JH\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\u0006\u0010\u0012\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00182\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ,\u00100\u001a\b\u0012\u0004\u0012\u00020$0\u00172\u0006\u0010\u0012\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ:\u00101\u001a\b\u0012\u0004\u0012\u00020$0\u00172\u0006\u0010\u0012\u001a\u00020\b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ \u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u0012\u001a\u00020\b2\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u0019J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u0019J\u0016\u0010:\u001a\u0002072\u0006\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u0019J\u000e\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020=J@\u0010;\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00042\u0018\u0010A\u001a\u0014\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00180BH\u0002J:\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180E2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002JH\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180E2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00182\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J,\u0010G\u001a\b\u0012\u0004\u0012\u00020$0E2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0018H\u0002JP\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010I\u001a\u00020J2\u0006\u0010>\u001a\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020@0\u00042\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00190B2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J(\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u00020O2\u0006\u0010>\u001a\u00020\n2\u0006\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u001dH\u0002J \u0010R\u001a\u00020\u00062\u0006\u0010N\u001a\u00020O2\u0006\u0010>\u001a\u00020\n2\u0006\u0010P\u001a\u00020@H\u0002J \u0010S\u001a\u00020\u00062\u0006\u0010N\u001a\u00020O2\u0006\u0010T\u001a\u00020U2\u0006\u0010P\u001a\u00020@H\u0002J(\u0010V\u001a\u00020\u00062\u0006\u0010N\u001a\u00020O2\u0006\u0010>\u001a\u00020\n2\u0006\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u001dH\u0002J \u0010W\u001a\u00020\u00062\u0006\u0010N\u001a\u00020O2\u0006\u0010T\u001a\u00020U2\u0006\u0010P\u001a\u00020@H\u0002J \u0010X\u001a\u00020\u00192\u0006\u0010N\u001a\u00020O2\u0006\u0010T\u001a\u00020U2\u0006\u0010P\u001a\u00020@H\u0002J \u0010Y\u001a\u00020Z2\u0006\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\\H\u0002J&\u0010]\u001a\u00020\\2\u0006\u0010P\u001a\u00020@2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010Q\u001a\u00020\u001dH\u0002J*\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u0019H\u0002J \u0010`\u001a\u0002072\u0006\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u00192\u0006\u0010a\u001a\u00020!H\u0002J\u0018\u0010b\u001a\u0002072\u0006\u0010>\u001a\u00020\n2\u0006\u00108\u001a\u00020_H\u0002J\u001e\u0010c\u001a\b\u0012\u0004\u0012\u00020!0d2\u0006\u0010e\u001a\u00020f2\u0006\u00108\u001a\u00020_H\u0002J(\u0010g\u001a\u00020h2\u0006\u0010>\u001a\u00020\n2\u0006\u00108\u001a\u00020_2\u0006\u00109\u001a\u00020\u00192\u0006\u0010a\u001a\u00020!H\u0002J \u0010i\u001a\u0002072\u0006\u0010j\u001a\u00020h2\u0006\u00109\u001a\u00020\u00192\u0006\u0010a\u001a\u00020!H\u0002JT\u0010k\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110E0\u00142\u0012\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110d0\u0014H\u0002J8\u0010n\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\u0012\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110d0\u0014H\u0002J&\u0010o\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010>\u001a\u00020\n2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0004H\u0002J$\u0010p\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010e\u001a\u00020f2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020/0\u0018H\u0002J\u001e\u0010r\u001a\u00020$2\u0006\u0010e\u001a\u00020f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0002J\u001e\u0010t\u001a\u00020$2\u0006\u0010e\u001a\u00020f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020@0\u0004H\u0002J$\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010e\u001a\u00020f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0002J/\u0010v\u001a\b\u0012\u0004\u0012\u0002H\u00110d\"\u0004\b\u0000\u0010\u00112\u0006\u0010w\u001a\u0002H\u00112\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0004H\u0002¢\u0006\u0002\u0010xJ0\u0010y\u001a\u0014\u0012\u0004\u0012\u00020@\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00180B2\u0006\u0010e\u001a\u00020f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020@0\u0004H\u0002J\u001e\u0010z\u001a\u00020$2\u0006\u0010e\u001a\u00020f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020@0\u0004H\u0002J*\u0010{\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00190B2\u0006\u0010e\u001a\u00020f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020@0\u0004H\u0002J\u0010\u0010|\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\nH\u0002J\u0010\u0010}\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u001e\u0010~\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u007fH\u0002J\u001d\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u00182\f\u0010q\u001a\b\u0012\u0004\u0012\u00020/0\u0018H\u0002J\u001a\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010N\u001a\u00020O2\u0007\u0010\u0082\u0001\u001a\u00020$H\u0002J-\u0010\u0083\u0001\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010N\u001a\u00020O2\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0014H\u0082\b¢\u0006\u0003\u0010\u0085\u0001J\u0012\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0006\u0010N\u001a\u00020OH\u0002J\u0011\u0010\u0088\u0001\u001a\u00020\u00062\u0006\u0010N\u001a\u00020OH\u0002J,\u0010\u0089\u0001\u001a\u00020O2\u0006\u0010\u0012\u001a\u00020\b2\u0007\u0010\u008a\u0001\u001a\u00020J2\u0007\u0010\u008b\u0001\u001a\u00020$2\u0007\u0010\u008c\u0001\u001a\u00020$H\u0002J\u0011\u0010\u008d\u0001\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u001dH\u0002J\r\u0010\u008e\u0001\u001a\u00020\u0019*\u00020\u001dH\u0002J\r\u0010\u008f\u0001\u001a\u00020@*\u00020\u001bH\u0002J\u001e\u0010\u0090\u0001\u001a\u00020\u0005*\u00020@2\u0006\u0010\u0012\u001a\u00020\b2\u0007\u0010\u0091\u0001\u001a\u00020\u0019H\u0002J\u0018\u0010\u0092\u0001\u001a\u00020\u00062\r\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\u0094\u0001\u001a\u00020\u00062\u0007\u0010\u0095\u0001\u001a\u00020$H\u0002R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009f\u0001"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine;", "", "closedRoundDiscard", "Lkotlin/Function1;", "", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "", "failureLogger", "", "ownerStore", "Lcom/obric/memorydata/database/index/OwnerStore;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "pendingOnlyReplayScope", "Ljava/lang/ThreadLocal;", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyReplayScope;", "runPendingOnlyReplayTransaction", ExifInterface.GPS_DIRECTION_TRUE, "ownerDbType", "replayBody", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "insertAll", "Lcom/obric/memorydata/database/index/PendingMutationResult;", "", "", "pending", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "startEvidence", "Lcom/obric/memorydata/database/index/StartEvidence;", "transactionMode", "Lcom/obric/memorydata/database/index/GatewayTransactionMode;", "recordCoverageRoundWithoutPending", "", "rawDbId", "entityType", "", "sourceTimestamp", "insertIfColumnAbsent", "replaceLegacyBuildTypeForOwner", "rawDbIds", "entityTypes", "buildTypes", "replacement", "replaceLegacyBuildTypeForOwner$database_obricRelease", "replace", "deletes", "Lcom/obric/memorydata/database/index/PendingDeleteSpec;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "rawDelete", "acquireExecutionLease", "Lcom/obric/memorydata/database/index/ExecutionHandle;", "pendingId", "expectedTimestamp", "settleSuccess", "Lcom/obric/memorydata/database/index/ExecutionSettlement;", "handle", "completedAtMs", "settleTerminalFailure", "finalizePendingOnlyReplay", "receipt", "Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;", "store", "touchedKeys", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$EntityKey;", "expectedPendingState", "", "Lcom/obric/memorydata/database/index/PendingRowFingerprint;", "observedInsertAll", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$ObservedMutation;", "observedReplace", "observedCancel", "applyCardinalityTransitions", "mutationKind", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$MutationKind;", "keys", "countsBefore", "reopenRoundForNewSourceIfNeeded", "context", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$ObservationContext;", "key", "evidence", "synchronizeCoverageRound", "invalidateCoverage", "lifecycleDao", "Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "openRound", "ensureActiveLifecycle", "closeWithoutCompletion", "initialLifecycle", "Lcom/obric/memorydata/database/entity/EntityIndexLifecycleEntity;", "coverage", "Lcom/obric/memorydata/database/index/CoverageRoundInitialization;", "coverageRoundInitialization", "observedAcquireExecutionLease", "Lcom/obric/memorydata/database/index/DatabaseExecutionHandle;", "settleExecution", "success", "pendingOnlySettlementAfterRollback", "pendingOnlySettlement", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyMutation;", "pendingDao", "Lcom/obric/memorydata/database/dao/IndexPendingDao;", "observedSettlement", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$SettlementTransactionResult;", "materializeCommittedSettlement", "committed", "executeMutation", "observed", "pendingOnly", "fallbackAfterRollback", "invalidateAfterFallback", "selectRows", "specs", "deleteExactRows", "rows", "deletePendingForKeys", "insertPendingOnly", "pendingOnlyMutation", "businessResult", "(Ljava/lang/Object;Ljava/util/Set;)Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyMutation;", "capturePendingState", "capturePendingCountSafely", "countsByKey", "requireCallerTransaction", "requireKnownOwner", "requireEntityTypesOwnedBy", "", "deleteSpecEntityTypes", "requireSingleLifecycleUpdate", "updatedRows", "lifecycleCall", "block", "(Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$ObservationContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observationFailure", "", "logFailure", "observationContext", "mutation", "pendingCount", "entityCount", "requireHomogeneousEvidence", "startedAtOrZero", "entityKey", "roundIdentity", "roundId", "discardClosedRoundsFailOpen", "rounds", "logClosedRoundDiscardFailure", "roundCount", "EntityKey", "ObservedMutation", "PendingOnlyMutation", "SettlementTransactionResult", "ObservationContext", "PendingOnlyReplayRecord", "PendingOnlyReplayScope", "MutationKind", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IndexPendingLifecycleGatewayEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f9306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<Set<ai.c>, Unit> f9307b;
    private final Function1<String, Unit> c;
    private final Function1<String, av> d;
    private final ThreadLocal<g> e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$MutationKind;", "", "<init>", "(Ljava/lang/String;I)V", "INSERT", "REPLACE", "CANCEL", "RAW_DELETE", "ACQUIRE", "SUCCESS", "TERMINAL_FAILURE", "INVALIDATE", "REPLAY_FINALIZE", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum MutationKind extends Enum<MutationKind> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MutationKind[] $VALUES = null;
        public static final MutationKind ACQUIRE = null;
        public static final MutationKind CANCEL = null;
        public static final MutationKind INSERT = null;
        public static final MutationKind INVALIDATE = null;
        public static final MutationKind RAW_DELETE = null;
        public static final MutationKind REPLACE = null;
        public static final MutationKind REPLAY_FINALIZE = null;
        public static final MutationKind SUCCESS = null;
        public static final MutationKind TERMINAL_FAILURE = null;

        private static final /* synthetic */ MutationKind[] $values() {
            return new MutationKind[]{INSERT, REPLACE, CANCEL, RAW_DELETE, ACQUIRE, SUCCESS, TERMINAL_FAILURE, INVALIDATE, REPLAY_FINALIZE};
        }

        static {
            INSERT = new MutationKind("INSERT", 0);
            REPLACE = new MutationKind("REPLACE", 1);
            CANCEL = new MutationKind("CANCEL", 2);
            RAW_DELETE = new MutationKind("RAW_DELETE", 3);
            ACQUIRE = new MutationKind("ACQUIRE", 4);
            SUCCESS = new MutationKind("SUCCESS", 5);
            TERMINAL_FAILURE = new MutationKind("TERMINAL_FAILURE", 6);
            INVALIDATE = new MutationKind("INVALIDATE", 7);
            REPLAY_FINALIZE = new MutationKind("REPLAY_FINALIZE", 8);
            MutationKind[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private MutationKind(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<MutationKind> getEntries() {
            return $ENTRIES;
        }

        public static MutationKind valueOf(String r2) {
            return (MutationKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(MutationKind.class, r2), MutationKind.class, "com.obric.memorydata.plugin");
        }

        public static MutationKind[] values() {
            return (MutationKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MutationKind[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$Companion;", "", "<init>", "()V", "TAG", "", "SQLITE_BIND_CHUNK", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$EntityKey;", "", "rawDbId", "", "entityType", "", "<init>", "(JI)V", "getRawDbId", "()J", "getEntityType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9309b;

        public b(long r1, int r3) {
            this.f9308a = r1;
            this.f9309b = r3;
        }

        public final long a() {
            return this.f9308a;
        }

        public final int b() {
            return this.f9309b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.f9308a == r10.f9308a) goto L12;
            return false;
        L12:
            if (this.f9309b == r10.f9309b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f9308a) * 31) + Integer.hashCode(this.f9309b);
        }

        public String toString() {
            return "EntityKey(rawDbId=" + this.f9308a + ", entityType=" + this.f9309b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$ObservationContext;", "", "ownerDbType", "", "mutation", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$MutationKind;", "pendingCount", "", "entityCount", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$MutationKind;II)V", "getOwnerDbType", "()Ljava/lang/String;", "getMutation", "()Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$MutationKind;", "getPendingCount", "()I", "getEntityCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MutationKind f9311b;
        private final int c;
        private final int d;

        public c(String r2, MutationKind r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "ownerDbType");
            Intrinsics.checkNotNullParameter(r3, "mutation");
            this.f9310a = r2;
            this.f9311b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final String a() {
            return this.f9310a;
        }

        public final MutationKind b() {
            return this.f9311b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9310a, r6.f9310a) == true) goto L12;
            return false;
        L12:
            if (this.f9311b == r6.f9311b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f9310a.hashCode() * 31) + this.f9311b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "ObservationContext(ownerDbType=" + this.f9310a + ", mutation=" + this.f9311b + ", pendingCount=" + this.c + ", entityCount=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J>\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$ObservedMutation;", ExifInterface.GPS_DIRECTION_TRUE, "", "businessResult", "touchedKeys", "", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$EntityKey;", "closedRounds", "Lcom/obric/memorydata/database/index/IndexDashboardLatencyTracker$EntityRoundIdentity;", "<init>", "(Ljava/lang/Object;Ljava/util/Set;Ljava/util/Set;)V", "getBusinessResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTouchedKeys", "()Ljava/util/Set;", "getClosedRounds", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/util/Set;Ljava/util/Set;)Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$ObservedMutation;", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f9312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<b> f9313b;
        private final Set<ai.c> c;

        public d(T r3, Set<b> r4, Set<ai.c> r5) {
            Set<b> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Set<ai.c> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "touchedKeys");
            Intrinsics.checkNotNullParameter(r7, "closedRounds");
            this.f9312a = r3;
            this.f9313b = r6;
            this.c = r7;
        }

        public final T a() {
            return this.f9312a;
        }

        public final Set<ai.c> b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9312a, r6.f9312a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9313b, r6.f9313b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            T r0 = this.f9312a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.f9313b.hashCode()) * 31) + this.c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ObservedMutation(businessResult=" + this.f9312a + ", touchedKeys=" + this.f9313b + ", closedRounds=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyMutation;", ExifInterface.GPS_DIRECTION_TRUE, "", "businessResult", "touchedKeys", "", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$EntityKey;", "<init>", "(Ljava/lang/Object;Ljava/util/Set;)V", "getBusinessResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTouchedKeys", "()Ljava/util/Set;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/util/Set;)Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyMutation;", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f9314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<b> f9315b;

        public e(T r3, Set<b> r4) {
            Set<b> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "touchedKeys");
            this.f9314a = r3;
            this.f9315b = r5;
        }

        public final T a() {
            return this.f9314a;
        }

        public final Set<b> b() {
            return this.f9315b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9314a, r6.f9314a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9315b, r6.f9315b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            T r0 = this.f9314a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f9315b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "PendingOnlyMutation(businessResult=" + this.f9314a + ", touchedKeys=" + this.f9315b + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyReplayRecord;", "", "<init>", "()V", "committed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "finalized", "finalizeBlock", "Lkotlin/Function0;", "", "receipt", "Lcom/obric/memorydata/database/index/DatabasePendingOnlyReplayReceipt;", "seal", "", "markCommitted", "finalizeOnce", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f9316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f9317b;
        private Function0<Boolean> c;
        private final o d;

        public f() {
            AtomicBoolean r0 = new AtomicBoolean(false);
            this.f9316a = r0;
            this.f9317b = new AtomicBoolean(false);
            this.d = new o((Function0) ZeusTransformUtils.preCheckCast(new IndexPendingLifecycleGatewayEngine$PendingOnlyReplayRecord$receipt$1(r0), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new IndexPendingLifecycleGatewayEngine$PendingOnlyReplayRecord$receipt$2(this), Function0.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ boolean a(f r0) {
            return r0.c();
        }

        private final boolean c() {
            if (this.f9317b.compareAndSet(false, true) == true) goto L5;
            return false;
        L5:
            Function0<Boolean> r3 = this.c;
            if (r3 != null) goto L8;
            return false;
        L8:
            return ((Boolean) ZeusTransformUtils.preCheckCast(r3.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        public final o a() {
            return this.d;
        }

        public final void a(Function0<Boolean> r3) {
            Function0<Boolean> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "finalizeBlock");
            this.c = r4;
        }

        public final void b() {
            this.f9316a.set(true);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyReplayScope;", "", "ownerDbType", "", "<init>", "(Ljava/lang/String;)V", "getOwnerDbType", "()Ljava/lang/String;", "record", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyReplayRecord;", "getRecord", "()Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$PendingOnlyReplayRecord;", "touchedKeys", "Ljava/util/LinkedHashSet;", "Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$EntityKey;", "Lkotlin/collections/LinkedHashSet;", "getTouchedKeys", "()Ljava/util/LinkedHashSet;", "register", "Lcom/obric/memorydata/database/index/DatabasePendingOnlyReplayReceipt;", "keys", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f9319b;
        private final LinkedHashSet<b> c;

        public g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "ownerDbType");
            this.f9318a = r2;
            this.f9319b = new f();
            this.c = new LinkedHashSet();
        }

        public final o a(Set<b> r4) {
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "keys");
            CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));
            return this.f9319b.a();
        }

        public final String a() {
            return this.f9318a;
        }

        public final f b() {
            return this.f9319b;
        }

        public final LinkedHashSet<b> c() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/index/IndexPendingLifecycleGatewayEngine$SettlementTransactionResult;", "", "pendingDeleted", "", "roundClosed", "firstCompletionStartedAtMs", "", "firstCompletionWasFinished", "firstCompletionCompletedNow", "<init>", "(ZZJZZ)V", "getPendingDeleted", "()Z", "getRoundClosed", "getFirstCompletionStartedAtMs", "()J", "getFirstCompletionWasFinished", "getFirstCompletionCompletedNow", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f9320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f9321b;
        private final long c;
        private final boolean d;
        private final boolean e;

        public h(boolean r1, boolean r2, long r3, boolean r5, boolean r6) {
            this.f9320a = r1;
            this.f9321b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public /* synthetic */ h(boolean r8, boolean r9, long r10, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 4) == 0) goto L5;
            r10 = 0;
        L5:
            long r3 = r10;
            if ((r14 & 8) == 0) goto L8;
            r12 = true;
        L8:
            boolean r5 = r12;
            if ((r14 & 16) == 0) goto L11;
            r13 = false;
        L11:
            this(r8, r9, r3, r5, r13);
        }

        public final boolean a() {
            return this.f9320a;
        }

        public final boolean b() {
            return this.f9321b;
        }

        public final long c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, h.class) == true) goto L8;
            return false;
        L8:
            h r10 = (h) ZeusTransformUtils.preCheckCast(r9, h.class, "com.obric.memorydata.plugin");
            if (this.f9320a == r10.f9320a) goto L12;
            return false;
        L12:
            if (this.f9321b == r10.f9321b) goto L15;
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
            return (((((((Boolean.hashCode(this.f9320a) * 31) + Boolean.hashCode(this.f9321b)) * 31) + Long.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "SettlementTransactionResult(pendingDeleted=" + this.f9320a + ", roundClosed=" + this.f9321b + ", firstCompletionStartedAtMs=" + this.c + ", firstCompletionWasFinished=" + this.d + ", firstCompletionCompletedNow=" + this.e + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9322a = null;

        static {
            int[] r0 = new int[GatewayTransactionMode.values().length];
            r0[GatewayTransactionMode.OWNED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[GatewayTransactionMode.OBSERVED_IN_CALLER_TRANSACTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[GatewayTransactionMode.PENDING_ONLY_IN_CALLER_TRANSACTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f9322a = r0;
        }
    }

    static {
        f9306a = new a(null);
    }

    public IndexPendingLifecycleGatewayEngine(Function1<? super Set<ai.c>, Unit> r3, Function1<? super String, Unit> r4, Function1<? super String, av> r5) {
        Function1<Set<ai.c>, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1<String, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<String, av> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "closedRoundDiscard");
        Intrinsics.checkNotNullParameter(r7, "failureLogger");
        Intrinsics.checkNotNullParameter(r8, "ownerStore");
        this.f9307b = r6;
        this.c = r7;
        this.d = r8;
        this.e = new ThreadLocal();
    }

    public /* synthetic */ IndexPendingLifecycleGatewayEngine(Function1 r2, Function1 r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = $$Lambda$IndexPendingLifecycleGatewayEngine$uZmD6G8ititeJUYZTUVRQeoMNjI.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r8 = $$Lambda$IndexPendingLifecycleGatewayEngine$6OGfNbVkhgSrlSoKZApV2gsh_w.INSTANCE;
    L8:
        this(r7, r8, r9);
    }

    private final int a(IndexPendingDao r8, Set<b> r9) {
        IndexPendingDao r7 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r8, IndexPendingDao.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r1 = r12.next();
        Integer r2 = Integer.valueOf(((b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin")).b());
        Object r3 = r11.get(r2);
        if (r3 != null) goto L8;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r11.put(r2, r3);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).add(r1);
        goto L4
    L9:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
    L11:
        if (r13.hasNext() == false) goto L21;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.add(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r16.next(), b.class, "com.obric.memorydata.plugin")).a()));
        goto L14
    L16:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 900), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r18 = 0;
    L18:
        if (r17.hasNext() == false) goto L20;
        r18 = r18 + r7.deleteAllByRawDbIds((List) ZeusTransformUtils.preCheckCast(r17.next(), List.class, "com.obric.memorydata.plugin"), r6);
        goto L18
    L20:
        r4 = r4 + r18;
        goto L11
    L21:
        return r4;
    }

    private final bh a(b r26, bc r27, k r28) {
        bc r0 = (bc) ZeusTransformUtils.wrapperContextForParams(r27, bc.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, bc.c.class) == false) goto L6;
        return new bh(r26.a(), r26.b(), ((bc.c) ZeusTransformUtils.preCheckCast(r0, bc.c.class, "com.obric.memorydata.plugin")).a(), ((bc.c) ZeusTransformUtils.preCheckCast(r0, bc.c.class, "com.obric.memorydata.plugin")).a(), false, 1, ((bc.c) ZeusTransformUtils.preCheckCast(r0, bc.c.class, "com.obric.memorydata.plugin")).a(), r28.a(), r28.b(), r28.c(), 0, 0, r28.d(), 3088, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, bc.a.class) == false) goto L9;
        return new bh(r26.a(), r26.b(), 0, ((bc.a) ZeusTransformUtils.preCheckCast(r0, bc.a.class, "com.obric.memorydata.plugin")).a(), true, 1, ((bc.a) ZeusTransformUtils.preCheckCast(r0, bc.a.class, "com.obric.memorydata.plugin")).a(), r28.a(), r28.b(), r28.c(), 0, 0, r28.d(), 3076, null);
    L9:
        if (Intrinsics.areEqual(r0, bc.b.f9410a) == false) goto L13;
        return new bh(r26.a(), r26.b(), 0, 0, false, 1, 0, 0, 0, 0, 0, 0, 0, 8156, null);
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final b a(cd r3) {
        return new b(r3.b(), r3.c());
    }

    private final c a(String r1, MutationKind r2, int r3, int r4) {
        return new c(r1, r2, r3, r4);
    }

    private static final d a(IndexPendingLifecycleGatewayEngine r2, String r3, av r4, List r5) {
        return r2.a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"));
    }

    private static final d a(IndexPendingLifecycleGatewayEngine r2, String r3, av r4, List r5, bc r6) {
        return r2.a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), (bc) ZeusTransformUtils.wrapperContextForParams(r6, bc.class, "com.obric.memorydata.plugin"));
    }

    private static final d a(IndexPendingLifecycleGatewayEngine r8, String r9, av r10, List r11, List r12, bc r13) {
        return r8.a(r9, r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (bc) ZeusTransformUtils.wrapperContextForParams(r13, bc.class, "com.obric.memorydata.plugin"));
    }

    private static final d a(IndexPendingLifecycleGatewayEngine r11, String r12, LinkedHashSet r13, av r14) {
        c r0 = r11.a(r12, MutationKind.RAW_DELETE, r13.size(), r13.size());
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L22;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin");
        bh r5 = r14.c().query(r4.a(), r4.b());     // Catch: SQLiteException -> L20
        ai.c r6 = null;
        if (r5 != null) goto L10;
    L18:
        if (r6 == null) goto L4;
        r3.add(r6);
        goto L4
    L10:
        if (r5.f() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        r6 = r11.a(r4, r12, r5.f());
        goto L18
    L12:
        r7 = false;
    L20:
        r11.a(r0);
        throw new KotlinNothingValueException();
    L22:
        LinkedHashSet r15 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r3, LinkedHashSet.class, "com.obric.memorydata.plugin");
        int r8 = r11.a(r14.b(), (Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.memorydata.plugin"));
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r9.hasNext() == false) goto L31;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.memorydata.plugin");
        r14.c().delete(r10.a(), r10.b());     // Catch: SQLiteException -> L28
        Unit r16 = Unit.INSTANCE;     // Catch: SQLiteException -> L28
    L28:
        r11.a(r0);
        throw new KotlinNothingValueException();
    L31:
        return new d(Integer.valueOf(r8), (Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.memorydata.plugin"));
    }

    private static final d a(av r9, cd r10, IndexPendingLifecycleGatewayEngine r11, b r12, String r13, bc r14) {
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r14, bc.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9.b().queryWithRawDbAndColumn(r10.b(), r10.c(), r10.h()), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L7;
        Map<b, Long> r7 = r11.d(r9.b(), SetsKt.setOf(r12));
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.single(r11.c(r9.b(), CollectionsKt.listOf(r10))), Number.class, "com.obric.memorydata.plugin")).longValue();
        return new d(Long.valueOf(r0), SetsKt.setOf(r12), r11.a(r13, MutationKind.INSERT, r9, SetsKt.setOf(r12), r7, r8));
    L7:
        return new d(null, SetsKt.emptySet(), SetsKt.emptySet());
    }

    private final d<Integer> a(String r12, av r13, List<? extends ax> r14) {
        List<? extends ax> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List<cd> r16 = a(r13.b(), r15);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(a((cd) ZeusTransformUtils.preCheckCast(r1.next(), cd.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        LinkedHashSet r3 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r2, LinkedHashSet.class, "com.obric.memorydata.plugin");
        Map<b, Long> r9 = d(r13.b(), (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
        int r17 = b(r13.b(), r16);
        Set<ai.c> r11 = a(r12, MutationKind.CANCEL, r13, (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"), r9, (bc) ZeusTransformUtils.preCheckCast(bc.b.f9410a, bc.class, "com.obric.memorydata.plugin"));
        return new d(Integer.valueOf(r17), (Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"), r11);
    }

    private final d<List<Long>> a(String r10, av r11, List<cd> r12, bc r13) {
        List<cd> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r13, bc.class, "com.obric.memorydata.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r0.add(a((cd) ZeusTransformUtils.preCheckCast(r16.next(), cd.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        LinkedHashSet r17 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r0, LinkedHashSet.class, "com.obric.memorydata.plugin");
        Map<b, Long> r7 = d(r11.b(), (Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.memorydata.plugin"));
        List<Long> r18 = c(r11.b(), r14);
        Set<ai.c> r9 = a(r10, MutationKind.INSERT, r11, (Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.memorydata.plugin"), r7, r8);
        return new d(r18, (Set) ZeusTransformUtils.preCheckCast(r17, Set.class, "com.obric.memorydata.plugin"), r9);
    }

    private final d<List<Long>> a(String r10, av r11, List<? extends ax> r12, List<cd> r13, bc r14) {
        List<? extends ax> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<cd> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r14, bc.class, "com.obric.memorydata.plugin");
        List<cd> r17 = a(r11.b(), r15);
        LinkedHashSet r18 = new LinkedHashSet();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Object r2 = r0.next();
        ((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).add(a((cd) ZeusTransformUtils.preCheckCast(r2, cd.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        ((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).add(a((cd) ZeusTransformUtils.preCheckCast(r4, cd.class, "com.obric.memorydata.plugin")));
        goto L8
    L10:
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin");
        Map<b, Long> r7 = d(r11.b(), (Set) ZeusTransformUtils.preCheckCast(r18, Set.class, "com.obric.memorydata.plugin"));
        b(r11.b(), r17);
        List<Long> r19 = c(r11.b(), r16);
        Set<ai.c> r9 = a(r10, MutationKind.REPLACE, r11, (Set) ZeusTransformUtils.preCheckCast(r18, Set.class, "com.obric.memorydata.plugin"), r7, r8);
        return new d(r19, (Set) ZeusTransformUtils.preCheckCast(r18, Set.class, "com.obric.memorydata.plugin"), r9);
    }

    private static final d a(Function0 r2) {
        return (d) ZeusTransformUtils.preCheckCast(((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke(), d.class, "com.obric.memorydata.plugin");
    }

    private final e<Boolean> a(IndexPendingDao r8, l r9) {
        IndexPendingDao r10 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r8, IndexPendingDao.class, "com.obric.memorydata.plugin");
        b r0 = new b(r9.b(), r9.c());
        cd r1 = r10.queryByIdAndTimestamp(r9.e(), r9.f());
        boolean r2 = false;
        if (r1 != null) goto L5;
    L15:
        boolean r11 = false;
        Set<b> r12 = SetsKt.emptySet();
    L14:
        return a(r11, r12);
    L5:
        if (r1.b() != r9.b()) goto L15;
        if (r1.c() != r9.c()) goto L15;
        if (r10.deleteByIdAndTimestamp(r9.e(), r9.f()) != 1) goto L12;
        r2 = true;
    L12:
        r11 = Boolean.valueOf(r2);
        r12 = SetsKt.setOf(r0);
        goto L14
    }

    private static final e a(IndexPendingLifecycleGatewayEngine r0, av r1, l r2) {
        return r0.a(r1.b(), r2);
    }

    private static final e a(IndexPendingLifecycleGatewayEngine r2, av r3, LinkedHashSet r4) {
        return r2.a(Integer.valueOf(r2.a(r3.b(), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"))), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"));
    }

    private static final e a(IndexPendingLifecycleGatewayEngine r4, av r5, List r6) {
        List<? extends ax> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<cd> r8 = r4.a(r5.b(), r7);
        Integer r9 = Integer.valueOf(r4.b(r5.b(), r8));
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r0.add(r4.a((cd) ZeusTransformUtils.preCheckCast(r11.next(), cd.class, "com.obric.memorydata.plugin")));
        goto L4
    L7:
        return r4.a(r9, (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"));
    }

    private static final e a(IndexPendingLifecycleGatewayEngine r2, av r3, List r4, LinkedHashSet r5) {
        List<cd> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        return r2.a(r2.c(r3.b(), r6), (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin"));
    }

    private static final e a(IndexPendingLifecycleGatewayEngine r5, av r6, List r7, List r8) {
        List<? extends ax> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<cd> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<cd> r11 = r5.a(r6.b(), r9);
        r5.b(r6.b(), r11);
        List<Long> r12 = r5.c(r6.b(), r10);
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Object r2 = r13.next();
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(r5.a((cd) ZeusTransformUtils.preCheckCast(r2, cd.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        Object r16 = r15.next();
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(r5.a((cd) ZeusTransformUtils.preCheckCast(r16, cd.class, "com.obric.memorydata.plugin")));
        goto L8
    L10:
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin");
        return r5.a(r12, (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"));
    }

    private static final e a(av r5, cd r6, IndexPendingLifecycleGatewayEngine r7, b r8) {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5.b().queryWithRawDbAndColumn(r6.b(), r6.c(), r6.h()), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        Long r9 = null;
        Set<b> r10 = SetsKt.emptySet();
    L7:
        return r7.a(r9, r10);
    L5:
        r9 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.single(r7.c(r5.b(), CollectionsKt.listOf(r6))), Number.class, "com.obric.memorydata.plugin")).longValue());
        r10 = SetsKt.setOf(r8);
        goto L7
    }

    private final <T> e<T> a(T r2, Set<b> r3) {
        return new e(r2, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    private static final h a(IndexPendingLifecycleGatewayEngine r0, av r1, l r2, long r3, boolean r5) {
        return r0.a(r1, r2, r3, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final h a(av r26, l r27, long r28, boolean r30) {
        cd r12 = r26.b().queryByIdAndTimestamp(r27.e(), r27.f());
        if (r12 == null) goto L94;
        if (r12.b() != r27.b()) goto L94;
        if (r12.c() != r27.c()) goto L94;
        if (r30 == false) goto L11;
        MutationKind r1 = MutationKind.SUCCESS;
    L12:
        c r14 = a(r27.a(), r1, 1, 1);
        bh r15 = r26.c().query(r27.b(), r27.c());     // Catch: SQLiteException -> L91
        if (r15 == null) goto L90;
        if (r15.f() != r27.d()) goto L90;
        if (r26.b().deleteForExecutionSettlement(r27.e(), r27.f(), r27.b(), r27.c(), r27.d()) != 1) goto L21;
        IndexDashboardCoverageV1Policy.PendingClassification r2 = IndexDashboardCoverageV1Policy.f9304a.a(r12.c(), r12.h(), r12.i());
        if (r30 == false) goto L25;
    L27:
        Object[] r3 = false;
    L28:
        boolean r4 = !IndexDashboardCoverageV1Policy.f9304a.a(r12.c());
        if (r2 == IndexDashboardCoverageV1Policy.PendingClassification.REQUIRED) goto L32;
        if (r3 == true) goto L32;
        if (r4 == true) goto L32;
    L65:
        if (r26.b().queryCountWithRawDb(r27.b(), r27.c()) <= 0) goto L97;
        a(r14, r26, a(r12));
        return new h(true, false, 0, false, false, 28, null);
    L97:
        if (r30 == false) goto L71;
        int r5 = r26.c().closeSuccess(r27.b(), r27.c(), r27.d(), r28);     // Catch: SQLiteException -> L87
    L72:
        a(r14, r5);
        bh r6 = r26.c().query(r27.b(), r27.c());     // Catch: SQLiteException -> L85
        if (r6 == null) goto L83;
        long r7 = r15.c();
        boolean r8 = r15.e();
        if (r15.e() == false) goto L78;
    L80:
        boolean r9 = false;
    L82:
        return new h(true, true, r7, r8, r9);
    L78:
        if (r6.e() == false) goto L80;
        r9 = true;
        goto L82
    L83:
        a(r14);
        throw new KotlinNothingValueException();
    L85:
        a(r14);
        throw new KotlinNothingValueException();
    L71:
        r5 = r26.c().closeTerminalFailure(r27.b(), r27.c(), r27.d(), r28);     // Catch: SQLiteException -> L87
    L87:
        a(r14);
        throw new KotlinNothingValueException();
    L32:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r26.b().queryWithRawDb(r27.b(), r27.c()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L35;
    L37:
        Iterator r11 = r10.iterator();
    L39:
        if (r11.hasNext() == false) goto L36;
        cd r13 = (cd) ZeusTransformUtils.preCheckCast(r11.next(), cd.class, "com.obric.memorydata.plugin");
        if (r13.d() == r12.d()) goto L43;
    L47:
        Object[] r16 = false;
    L48:
        if (r16 == false) goto L39;
        Object[] r17 = true;
    L50:
        if (r17 == true) goto L65;
        EntityIndexLifecycleDao r18 = r26.c();     // Catch: SQLiteException -> L62
        long r19 = r27.b();     // Catch: SQLiteException -> L62
        int r20 = r27.c();     // Catch: SQLiteException -> L62
        long r21 = r27.d();     // Catch: SQLiteException -> L62
        if (r4 == false) goto L54;
        int r22 = -1;
    L55:
        long r110 = r12.d();     // Catch: SQLiteException -> L62
        if (r3 == false) goto L58;
        int r111 = 1;
    L59:
        if (r18.recordCoverageSettlement(r19, r20, r21, r22, r110, r30 ? 1 : 0, r111) == 1) goto L65;
        a(r14, r26.c(), a(r12));
        goto L65
    L58:
        r111 = 0;
        goto L59
    L54:
        r22 = 1;
    L62:
        a(r14);
        throw new KotlinNothingValueException();
    L43:
        if (Intrinsics.areEqual(r13.h(), r12.h()) == false) goto L47;
        if (Intrinsics.areEqual(r13.i(), r12.i()) == false) goto L47;
        r16 = true;
    L36:
        r17 = false;
        goto L50
    L35:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L37;
    L25:
        if (r2 != IndexDashboardCoverageV1Policy.PendingClassification.DEFERRED) goto L27;
        r3 = true;
        goto L28
    L21:
        return new h(false, false, 0, false, false, 28, null);
    L90:
        return new h(false, false, 0, false, false, 28, null);
    L91:
        a(r14);
        throw new KotlinNothingValueException();
    L11:
        r1 = MutationKind.TERMINAL_FAILURE;
    L94:
        return new h(false, false, 0, false, false, 28, null);
    }

    private final ai.c a(b r8, String r9, long r10) {
        return new ai.c(r9, r8.b(), r8.a(), r10);
    }

    public static /* synthetic */ az a(IndexPendingLifecycleGatewayEngine r7, String r8, List r9, List r10, bc r11, GatewayTransactionMode r12, int r13, Object r14) {
        List<? extends ax> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<cd> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        bc r5 = (bc) ZeusTransformUtils.wrapperContextForParams(r11, bc.class, "com.obric.memorydata.plugin");
        if ((r13 & 16) == 0) goto L6;
        r12 = GatewayTransactionMode.OWNED;
    L6:
        return r7.a(r8, r3, r4, r5, r12);
    }

    private final <T> az<T> a(String r9, av r10, GatewayTransactionMode r11, Function0<d<T>> r12, Function0<e<T>> r13) {
        final Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        Function0<e<T>> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        int r16 = i.f9322a[r11.ordinal()];
        if (r16 == 1) goto L22;
        if (r16 != 2) goto L7;
        a(r10);
        Object r8 = ZeusTransformUtils.preCheckCast(new n(((d) ZeusTransformUtils.preCheckCast(r14.invoke(), d.class, "com.obric.memorydata.plugin")).a(), true, null, 4, null), az.class, "com.obric.memorydata.plugin");
    L31:
        return (az) r8;
    L7:
        if (r16 != 3) goto L18;
        a(r10);
        g r17 = (g) ZeusTransformUtils.preCheckCast(this.e.get(), g.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L11;
        String r18 = r17.a();
    L13:
        if (Intrinsics.areEqual(r18, r9) == false) goto L16;
        e r19 = (e) ZeusTransformUtils.preCheckCast(r15.invoke(), e.class, "com.obric.memorydata.plugin");
        r8 = ZeusTransformUtils.preCheckCast(new n(r19.a(), false, (ba) ZeusTransformUtils.preCheckCast(r17.a(r19.b()), ba.class, "com.obric.memorydata.plugin")), az.class, "com.obric.memorydata.plugin");
        goto L31
    L16:
        throw new IllegalStateException("pending-only caller mode requires the matching replay transaction wrapper".toString());
    L11:
        r18 = null;
        goto L13
    L18:
        throw new NoWhenBranchMatchedException();
    L22:
        if ((!r10.a().inTransaction()) == false) goto L28;
        d r110 = (d) ZeusTransformUtils.preCheckCast(r10.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$WfzaItKgkSnkbJiVuKvmlFUUtiY(r14)), d.class, "com.obric.memorydata.plugin");     // Catch: LifecycleObservationFailure -> L25
        a(r110.b());     // Catch: LifecycleObservationFailure -> L25
        return (az) ZeusTransformUtils.preCheckCast(new n(r110.a(), true, null, 4, null), az.class, "com.obric.memorydata.plugin");
    L26:
        return a(r9, r10, r15);
    L28:
        throw new IllegalArgumentException("OWNED gateway mode cannot run inside an existing owner transaction".toString());
    }

    private final <T> az<T> a(String r9, av r10, Function0<e<T>> r11) {
        final Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        if ((!r10.a().inTransaction()) == false) goto L7;
        e r13 = (e) ZeusTransformUtils.preCheckCast(r10.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$9tZBxlskqBkzqocIOHa_SGDNs9I(r12)), e.class, "com.obric.memorydata.plugin");
        a(r9, r10, r13.b());
        return (az) ZeusTransformUtils.preCheckCast(new n(r13.a(), false, null, 4, null), az.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("fallback must start only after the owning transaction has rolled back".toString());
    }

    private final k a(b r2, List<cd> r3, bc r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        bc r5 = (bc) ZeusTransformUtils.wrapperContextForParams(r4, bc.class, "com.obric.memorydata.plugin");
        return ap.a(r2.b(), r1, r5);
    }

    private final l a(String r22, av r23, long r24, long r26) {
        cd r2 = r23.b().queryByIdAndTimestamp(r24, r26);
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(com.obric.memorydata.database.manager.c.f9561a.a(r2.c()), r22) == true) goto L8;
        return null;
    L8:
        b r3 = a(r2);
        c r4 = a(r22, MutationKind.ACQUIRE, 1, 1);
        bh r5 = r23.c().query(r3.a(), r3.b());     // Catch: SQLiteException -> L55
        if (r5 != null) goto L16;
        b(r4, r23.c(), r3);
        r5 = r23.c().query(r3.a(), r3.b());     // Catch: SQLiteException -> L14
    L14:
        a(r4);
        throw new KotlinNothingValueException();
    L16:
        if (r5 == null) goto L53;
        long r14 = ap.a(r2, r5);
        bc.c r6 = new bc.c(r14);
        if (ap.a(r5, (bc) ZeusTransformUtils.preCheckCast(r6, bc.class, "com.obric.memorydata.plugin")) == false) goto L28;
        b(r4, r23, r3, (bc) ZeusTransformUtils.preCheckCast(r6, bc.class, "com.obric.memorydata.plugin"));
        r5 = r23.c().query(r3.a(), r3.b());     // Catch: SQLiteException -> L25
        if (r5 != null) goto L40;
        a(r4);
        throw new KotlinNothingValueException();
    L40:
        long r19 = r14;
    L42:
        if (r5.e() == true) goto L52;
        if (r5.c() != 0) goto L52;
        if (r19 <= 0) goto L52;
        a(r4, r23.c().markFirstCompletionStartedIfAbsent(r3.a(), r3.b(), r5.f(), r19));
    L49:
        a(r4);
        throw new KotlinNothingValueException();
    L52:
        return new l(r22, r3.a(), r3.b(), r5.f(), r24, r26);
    L25:
        a(r4);
        throw new KotlinNothingValueException();
    L28:
        if (ap.b(r5, (bc) ZeusTransformUtils.preCheckCast(r6, bc.class, "com.obric.memorydata.plugin")) == false) goto L40;
        r19 = r14;
        a(r4, r23.c().markFirstCompletionStartedForNewerSource(r3.a(), r3.b(), r5.f(), r19));
        r5 = r23.c().query(r3.a(), r3.b());     // Catch: SQLiteException -> L36
        if (r5 != null) goto L42;
        a(r4);
        throw new KotlinNothingValueException();
    L36:
        a(r4);
        throw new KotlinNothingValueException();
    L38:
        a(r4);
        throw new KotlinNothingValueException();
    L53:
        a(r4);
        throw new KotlinNothingValueException();
    L55:
        a(r4);
        throw new KotlinNothingValueException();
    }

    private static final u a(IndexPendingLifecycleGatewayEngine r0, String r1, av r2, long r3, long r5) {
        return (u) ZeusTransformUtils.preCheckCast(r0.a(r1, r2, r3, r5), u.class, "com.obric.memorydata.plugin");
    }

    private final v a(h r8, long r9, boolean r11) {
        if (r11 == true) goto L4;
    L14:
        w r7 = null;
    L16:
        return (v) ZeusTransformUtils.preCheckCast(new m(r8.a(), true, r8.b(), r7), v.class, "com.obric.memorydata.plugin");
    L4:
        if (r8.b() == false) goto L14;
        if (r8.d() == true) goto L14;
        if (r8.e() == false) goto L14;
        if (r8.c() <= 0) goto L14;
        if (r9 < r8.c()) goto L14;
        r7 = new w(r8.c(), r9, r9 - r8.c());
        goto L16
    }

    private final v a(final av r4, final l r5) {
        if ((!r4.a().inTransaction()) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r4.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$WKiWIRjHEnieWf8823hGlCheGQ(this, r4, r5)), e.class, "com.obric.memorydata.plugin");
        a(r5.a(), r4, r0.b());
        return (v) ZeusTransformUtils.preCheckCast(new m(((Boolean) ZeusTransformUtils.preCheckCast(r0.a(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false, false, null), v.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("pending-only settlement must begin after observed transaction rollback".toString());
    }

    private final v a(u r12, final long r13, final boolean r15) {
        u r14 = (u) ZeusTransformUtils.wrapperContextForParams(r12, u.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, l.class) == false) goto L5;
        l r16 = (l) ZeusTransformUtils.preCheckCast(r14, l.class, "com.obric.memorydata.plugin");
    L6:
        if (r16 == null) goto L8;
        final av r0 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r16.a()), av.class, "com.obric.memorydata.plugin");
        if ((!r0.a().inTransaction()) == false) goto L16;
        final l r6 = r16;
        return a((h) ZeusTransformUtils.preCheckCast(r0.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$ygfzR0FJHsQGXxf4gDdPujNsfU4(this, r0, r6, r13, r15)), h.class, "com.obric.memorydata.plugin"), r13, r15);
    L14:
        return a(r0, r16);
    L16:
        throw new IllegalStateException("execution settlement owns its transaction".toString());
    L8:
        return (v) ZeusTransformUtils.preCheckCast(new m(false, false, false, null), v.class, "com.obric.memorydata.plugin");
    L5:
        r16 = null;
        goto L6
    }

    private static final Boolean a(IndexPendingLifecycleGatewayEngine r10, av r11, Set r12, Map r13, c r14) {
        Set<b> r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10.b(r11.b(), r15), r16) == true) goto L5;
        boolean r17 = false;
    L15:
        return Boolean.valueOf(r17);
    L5:
        long r8 = System.currentTimeMillis();
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r18.hasNext() == false) goto L13;
        b r19 = (b) ZeusTransformUtils.preCheckCast(r18.next(), b.class, "com.obric.memorydata.plugin");
        r11.c().invalidateObservation(r19.a(), r19.b(), r8);     // Catch: SQLiteException -> L11
        Unit r110 = Unit.INSTANCE;     // Catch: SQLiteException -> L11
    L11:
        r10.a(r14);
        throw new KotlinNothingValueException();
    L13:
        r17 = true;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, com.obric.memorydata.database.index.bc] */
    private static final Boolean a(av r25, long r26, int r28, IndexPendingLifecycleGatewayEngine r29, c r30, Ref.ObjectRef r31, bc r32, long r33, long r35, Ref.ObjectRef r37) {
        bc r5 = (bc) ZeusTransformUtils.wrapperContextForParams(r32, bc.class, "com.obric.memorydata.plugin");
        if (r25.b().queryCountWithRawDb(r26, r28) == 0) goto L7;
        boolean r0 = false;
    L6:
        return Boolean.valueOf(r0);
    L7:
        b r1 = new b(r26, r28);
        bh r11 = r25.c().query(r26, r28);     // Catch: SQLiteException -> L64
        r31.element = ap.a(r11, r5, r33, r35);
        if (r11 == null) goto L12;
        Ref.ObjectRef r15 = r31;
        if (ap.a(r11, (bc) ZeusTransformUtils.preCheckCast(r15.element, bc.class, "com.obric.memorydata.plugin")) == false) goto L33;
        IndexPendingLifecycleGatewayEngine r10 = r29;
        r10.b(r30, r25, r1, (bc) ZeusTransformUtils.preCheckCast(r15.element, bc.class, "com.obric.memorydata.plugin"));
        r11 = r25.c().query(r26, r28);     // Catch: SQLiteException -> L31
    L68:
        EntityIndexLifecycleDao r2 = r25.c();     // Catch: SQLiteException -> L61
        if (r11 == null) goto L38;
        long r17 = r11.f();     // Catch: SQLiteException -> L61
    L39:
        IndexPendingLifecycleGatewayEngine r12 = r10;
        r12.a(r30, r2.resetCoverageRound(r26, r28, 1, r33, 0, 2, r17));
        if (r11 != null) goto L44;
        r29.a(r30);
        throw new KotlinNothingValueException();
    L44:
        if (ZeusTransformUtils.instanceOf(r15.element, bc.c.class) == true) goto L48;
        if (r11.c() == r33) goto L48;
    L57:
        r0 = true;
    L48:
        if (r11.e() == true) goto L57;
        if (r11.c() <= 0) goto L57;
        if (r35 < r11.c()) goto L57;
        r12.a(r30, r25.c().closeSuccess(r26, r28, r11.f(), r35));
        r37.element = Long.valueOf(r35 - r11.c());
    L55:
        r29.a(r30);
        throw new KotlinNothingValueException();
    L38:
        r17 = 0;
    L62:
        r29.a(r30);
        throw new KotlinNothingValueException();
    L31:
        r29.a(r30);
        throw new KotlinNothingValueException();
    L33:
        r10 = r29;
        goto L68
    L12:
        if (ZeusTransformUtils.instanceOf(r31.element, bc.c.class) == false) goto L14;
        bh r3 = r29.a(r1, (bc) ZeusTransformUtils.preCheckCast(r31.element, bc.class, "com.obric.memorydata.plugin"), new k(1, r33, 0, 2));
    L74:
        if (r25.c().insertIfAbsent(r3) != (-1)) goto L70;
        r29.a(r30);
        throw new KotlinNothingValueException();
    L70:
        r11 = r25.c().query(r26, r28);     // Catch: SQLiteException -> L20
        r10 = r29;
        r15 = r31;
    L20:
        r29.a(r30);
        throw new KotlinNothingValueException();
    L24:
        r29.a(r30);
        throw new KotlinNothingValueException();
    L14:
        r3 = new bh(r26, r28, 0, 0, false, 0, 0, 0, 0, 0, 0, 0, 0, 8188, null);
    L64:
        r29.a(r30);
        throw new KotlinNothingValueException();
    }

    private static final Object a(Function0 r7, g r8, final IndexPendingLifecycleGatewayEngine r9, final av r10, final String r11) {
        Object r12 = ((Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin")).invoke();
        final Set<b> r5 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r8.c(), Iterable.class, "com.obric.memorydata.plugin"));
        final Map<b, List<bb>> r6 = r9.b(r10.b(), r5);
        r8.b().a(new $$Lambda$IndexPendingLifecycleGatewayEngine$qbBsjQADTpXYtNQoEGU_c9__4w8(r9, r11, r10, r5, r6));
        return r12;
    }

    private final Void a(c r1) {
        b(r1);
        throw new DatabaseLifecycleObservationFailure();
    }

    private final List<cd> a(IndexPendingDao r14, List<? extends ax> r15) {
        IndexPendingDao r13 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r14, IndexPendingDao.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L4:
        if (r18.hasNext() == false) goto L72;
        ax r1 = (ax) ZeusTransformUtils.preCheckCast(r18.next(), ax.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        cd r5 = null;
        if (ZeusTransformUtils.instanceOf(r1, ax.d.class) == false) goto L26;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(((ax.d) ZeusTransformUtils.preCheckCast(r1, ax.d.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r2.iterator();
    L9:
        if (r6.hasNext() == false) goto L23;
        ay r7 = (ay) ZeusTransformUtils.preCheckCast(r6.next(), ay.class, "com.obric.memorydata.plugin");
        cd r8 = r13.queryByIdAndTimestamp(r7.a(), r7.b());
        if (r8 != null) goto L13;
    L20:
        r8 = null;
    L21:
        if (r8 == null) goto L9;
        r4.add(r8);
        goto L9
    L13:
        if (r8.b() == r7.c()) goto L15;
    L17:
        boolean r9 = false;
    L18:
        if (r9 == false) goto L20;
    L15:
        if (r8.c() != r7.d()) goto L17;
        r9 = true;
        goto L18
    L23:
        Object r10 = ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    L24:
        List<cd> r11 = (List) r10;
    L69:
        CollectionsKt.addAll(r17, (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L26:
        if (ZeusTransformUtils.instanceOf(r1, ax.f.class) == false) goto L33;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(((ax.f) ZeusTransformUtils.preCheckCast(r1, ax.f.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin"), 900), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r12.iterator();
    L29:
        if (r20.hasNext() == false) goto L31;
        CollectionsKt.addAll(r19, (Iterable) ZeusTransformUtils.preCheckCast(r13.queryWithRawDbIds((List) ZeusTransformUtils.preCheckCast(r20.next(), List.class, "com.obric.memorydata.plugin"), ((ax.f) ZeusTransformUtils.preCheckCast(r1, ax.f.class, "com.obric.memorydata.plugin")).b()), Iterable.class, "com.obric.memorydata.plugin"));
    L31:
        r10 = ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        goto L24
    L33:
        if (ZeusTransformUtils.instanceOf(r1, ax.a.class) == false) goto L39;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(((ax.a) ZeusTransformUtils.preCheckCast(r1, ax.a.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin"), 900), Iterable.class, "com.obric.memorydata.plugin");
        r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r21.iterator();
    L36:
        if (r22.hasNext() == false) goto L31;
        CollectionsKt.addAll(r19, (Iterable) ZeusTransformUtils.preCheckCast(r13.queryByRawDbIdsAndBuildType((List) ZeusTransformUtils.preCheckCast(r22.next(), List.class, "com.obric.memorydata.plugin"), ((ax.a) ZeusTransformUtils.preCheckCast(r1, ax.a.class, "com.obric.memorydata.plugin")).b(), ((ax.a) ZeusTransformUtils.preCheckCast(r1, ax.a.class, "com.obric.memorydata.plugin")).c()), Iterable.class, "com.obric.memorydata.plugin"));
        goto L36
    L39:
        if (ZeusTransformUtils.instanceOf(r1, ax.c.class) == false) goto L42;
        r11 = r13.queryByEntityTypeAndBuildType(((ax.c) ZeusTransformUtils.preCheckCast(r1, ax.c.class, "com.obric.memorydata.plugin")).a(), ((ax.c) ZeusTransformUtils.preCheckCast(r1, ax.c.class, "com.obric.memorydata.plugin")).b());
        goto L69
    L42:
        if (ZeusTransformUtils.instanceOf(r1, ax.b.class) == false) goto L45;
        r11 = r13.queryWithRawDbAndColumn(((ax.b) ZeusTransformUtils.preCheckCast(r1, ax.b.class, "com.obric.memorydata.plugin")).a(), ((ax.b) ZeusTransformUtils.preCheckCast(r1, ax.b.class, "com.obric.memorydata.plugin")).b(), ((ax.b) ZeusTransformUtils.preCheckCast(r1, ax.b.class, "com.obric.memorydata.plugin")).c());
        goto L69
    L45:
        if (ZeusTransformUtils.instanceOf(r1, ax.e.class) == false) goto L56;
        cd r23 = r13.queryByIdAndTimestamp(((ax.e) ZeusTransformUtils.preCheckCast(r1, ax.e.class, "com.obric.memorydata.plugin")).a(), ((ax.e) ZeusTransformUtils.preCheckCast(r1, ax.e.class, "com.obric.memorydata.plugin")).b());
        if (r23 != null) goto L49;
    L54:
        r11 = CollectionsKt.listOfNotNull(r5);
        goto L69
    L49:
        if (r23.c() == ((ax.e) ZeusTransformUtils.preCheckCast(r1, ax.e.class, "com.obric.memorydata.plugin")).c()) goto L52;
        r3 = false;
    L52:
        if (r3 == false) goto L54;
        r5 = r23;
        goto L54
    L56:
        if (ZeusTransformUtils.instanceOf(r1, ar.class) == false) goto L71;
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(((ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin")).b(), Iterable.class, "com.obric.memorydata.plugin");
        r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r25 = r24.iterator();
    L59:
        if (r25.hasNext() == false) goto L31;
        int r26 = ((Number) ZeusTransformUtils.preCheckCast(r25.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(((ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L62:
        if (r29.hasNext() == false) goto L68;
        String r30 = (String) ZeusTransformUtils.preCheckCast(r29.next(), String.class, "com.obric.memorydata.plugin");
        Iterable r31 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(((ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin"), 900), Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r32 = r31.iterator();
    L65:
        if (r32.hasNext() == false) goto L67;
        CollectionsKt.addAll(r110, (Iterable) ZeusTransformUtils.preCheckCast(r13.queryByRawDbIdsAndBuildType((List) ZeusTransformUtils.preCheckCast(r32.next(), List.class, "com.obric.memorydata.plugin"), r26, r30), Iterable.class, "com.obric.memorydata.plugin"));
        goto L65
    L67:
        CollectionsKt.addAll(r28, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L62
    L68:
        CollectionsKt.addAll(r19, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L59
    L71:
        throw new NoWhenBranchMatchedException();
    L72:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r112 = new HashSet();
        ArrayList r113 = new ArrayList();
        Iterator r114 = r111.iterator();
    L74:
        if (r114.hasNext() == false) goto L79;
        Object r33 = r114.next();
        cd r34 = (cd) ZeusTransformUtils.preCheckCast(r33, cd.class, "com.obric.memorydata.plugin");
        if (r112.add(TuplesKt.to(Long.valueOf(r34.a()), Long.valueOf(r34.d()))) == false) goto L74;
        r113.add(r33);
        goto L74
    L79:
        return (List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin");
    }

    private final List<Integer> a(List<? extends ax> r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L35;
        ax r1 = (ax) ZeusTransformUtils.preCheckCast(r8.next(), ax.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ax.d.class) == false) goto L13;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(((ax.d) ZeusTransformUtils.preCheckCast(r1, ax.d.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        r3.add(Integer.valueOf(((ay) ZeusTransformUtils.preCheckCast(r4.next(), ay.class, "com.obric.memorydata.plugin")).d()));
        goto L9
    L11:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L31:
        CollectionsKt.addAll(r7, (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L13:
        if (ZeusTransformUtils.instanceOf(r1, ax.f.class) == false) goto L17;
        int r10 = ((ax.f) ZeusTransformUtils.preCheckCast(r1, ax.f.class, "com.obric.memorydata.plugin")).b();
    L15:
        r9 = CollectionsKt.listOf(Integer.valueOf(r10));
        goto L31
    L17:
        if (ZeusTransformUtils.instanceOf(r1, ax.a.class) == false) goto L20;
        r10 = ((ax.a) ZeusTransformUtils.preCheckCast(r1, ax.a.class, "com.obric.memorydata.plugin")).b();
        goto L15
    L20:
        if (ZeusTransformUtils.instanceOf(r1, ax.c.class) == false) goto L23;
        r10 = ((ax.c) ZeusTransformUtils.preCheckCast(r1, ax.c.class, "com.obric.memorydata.plugin")).a();
        goto L15
    L23:
        if (ZeusTransformUtils.instanceOf(r1, ax.b.class) == false) goto L26;
        r10 = ((ax.b) ZeusTransformUtils.preCheckCast(r1, ax.b.class, "com.obric.memorydata.plugin")).b();
        goto L15
    L26:
        if (ZeusTransformUtils.instanceOf(r1, ax.e.class) == false) goto L29;
        r10 = ((ax.e) ZeusTransformUtils.preCheckCast(r1, ax.e.class, "com.obric.memorydata.plugin")).c();
        goto L15
    L29:
        if (ZeusTransformUtils.instanceOf(r1, ar.class) == false) goto L33;
        r9 = CollectionsKt.emptyList();
        goto L31
    L33:
        throw new NoWhenBranchMatchedException();
    L35:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    }

    private final Set<ai.c> a(String r18, MutationKind r19, av r20, Set<b> r21, Map<b, Long> r22, bc r23) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r23, bc.class, "com.obric.memorydata.plugin");
        c r8 = a(r18, r19, r4.size(), r4.size());
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L28;
        b r10 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin");
        long r11 = ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r6, r10), Number.class, "com.obric.memorydata.plugin")).longValue();
        Iterator r24 = r5;
        long r13 = r20.b().queryCountWithRawDb(r10.a(), r10.b());
        if (r11 == 0) goto L8;
    L10:
        if (r11 > 0) goto L12;
    L22:
        if (r11 <= 0) goto L26;
        if (r13 != 0) goto L26;
        long r12 = c(r8, r20.c(), r10);
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).add(a(r10, r18, r12));
    L26:
        r5 = r24;
        goto L4
    L12:
        if (r13 <= 0) goto L22;
        if (a(r8, r20, r10, r7) == true) goto L26;
        b(r8, r20.c(), r10);
        if (r19 != MutationKind.CANCEL) goto L18;
    L21:
        a(r8, r20.c(), r10);
        goto L26
    L18:
        if (ZeusTransformUtils.instanceOf(r7, bc.b.class) == true) goto L21;
        a(r8, r20, r10);
        goto L26
    L8:
        if (r13 <= 0) goto L10;
        b(r8, r20, r10, r7);
        goto L26
    L28:
        return (Set) ZeusTransformUtils.preCheckCast(r9, Set.class, "com.obric.memorydata.plugin");
    }

    private final void a(int r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IndexPendingLifecycleGateway", "post-commit round discard failed roundCount=" + r7, null, 4, null);     // Catch: Throwable -> L4
        return;
    }

    private final void a(c r2, int r3) {
        if (r3 != 1) goto L5;
        return;
    L5:
        a(r2);
        throw new KotlinNothingValueException();
    }

    private final void a(c r4, EntityIndexLifecycleDao r5, b r6) {
        EntityIndexLifecycleDao r7 = (EntityIndexLifecycleDao) ZeusTransformUtils.wrapperContextForParams(r5, EntityIndexLifecycleDao.class, "com.obric.memorydata.plugin");
        if (r7.query(r6.a(), r6.b()) != null) goto L13;
        return;
    L13:
        a(r4, r7.invalidateCoverage(r6.a(), r6.b()));
        return;
    L9:
        a(r4);
        throw new KotlinNothingValueException();
    L11:
        a(r4);
        throw new KotlinNothingValueException();
    }

    private final void a(c r19, av r20, b r21) {
        k r3 = a(r21, r20.b().queryWithRawDb(r21.a(), r21.b()), (bc) ZeusTransformUtils.preCheckCast(new bc.a(0), bc.class, "com.obric.memorydata.plugin"));
        if (r3.a() != 0) goto L52;
    L4:
        a(r19, r20.c(), r21);
        return;
    L52:
        bh r4 = r20.c().query(r21.a(), r21.b());     // Catch: SQLiteException -> L46
        if (r4 != null) goto L9;
        a(r19);
        throw new KotlinNothingValueException();
    L9:
        if (r4.h() != r3.a()) goto L4;
        if (r4.i() <= 0) goto L4;
        if (r4.j() < 0) goto L4;
        if (r4.i() != r3.b()) goto L18;
        int r14 = (r4.k() + r4.l()) + r3.c();
        EntityIndexLifecycleDao r7 = r20.c();     // Catch: SQLiteException -> L42
        long r8 = r21.a();     // Catch: SQLiteException -> L42
        int r10 = r21.b();     // Catch: SQLiteException -> L42
        int r11 = r3.a();     // Catch: SQLiteException -> L42
        long r12 = r3.b();     // Catch: SQLiteException -> L42
        if (r3.a() != (-1)) goto L32;
        int r2 = 0;
    L30:
        int r15 = r2;
    L39:
        int r5 = r7.updateCoverageRequiredCount(r8, r10, r11, r12, r14, r15, r4.f());     // Catch: SQLiteException -> L42
    L40:
        a(r19, r5);
        return;
    L32:
        if (r3.d() == 2) goto L34;
    L38:
        r2 = 1;
        goto L30
    L34:
        if (r14 != r4.k()) goto L38;
        if (r4.l() != 0) goto L38;
        r15 = 2;
    L42:
        a(r19);
        throw new KotlinNothingValueException();
    L18:
        if (r4.k() > 0) goto L4;
        if (r4.l() > 0) goto L4;
        r5 = r20.c().resetCoverageRound(r21.a(), r21.b(), r3.a(), r3.b(), r3.c(), r3.d(), r4.f());     // Catch: SQLiteException -> L24
    L24:
        a(r19);
        throw new KotlinNothingValueException();
    L46:
        a(r19);
        throw new KotlinNothingValueException();
    }

    private final void a(av r1) {
        if (r1.a().inTransaction() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("caller transaction mode requires an active owner transaction".toString());
    }

    private final void a(bc r7) {
        bc r6 = (bc) ZeusTransformUtils.wrapperContextForParams(r7, bc.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (ZeusTransformUtils.instanceOf(r6, bc.c.class) == false) goto L13;
        if (((bc.c) ZeusTransformUtils.preCheckCast(r6, bc.c.class, "com.obric.memorydata.plugin")).a() > 0) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L13:
        if (ZeusTransformUtils.instanceOf(r6, bc.a.class) == false) goto L23;
        if (((bc.a) ZeusTransformUtils.preCheckCast(r6, bc.a.class, "com.obric.memorydata.plugin")).a() > 0) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L23:
        if (Intrinsics.areEqual(r6, bc.b.f9410a) == false) goto L26;
        return;
    L26:
        throw new NoWhenBranchMatchedException();
    }

    private final void a(String r1) {
        if (com.obric.memorydata.database.manager.c.f9561a.a().contains(r1) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("unknown index pending owner".toString());
    }

    private final void a(String r4, Collection<Integer> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        a(r4);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r3.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (Intrinsics.areEqual(com.obric.memorydata.database.manager.c.f9561a.a(r8), r4) == true) goto L9;
        r0 = false;
    L13:
        if (r0 == false) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("entity type does not belong to owner".toString());
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final void a(Set<ai.c> r3) {
        Set<ai.c> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L9;
        return;
    L9:
        this.f9307b.invoke(r4);     // Catch: Throwable -> L7
        return;
    L7:
        a(r4.size());
    }

    private static final void a(Set r10, IndexPendingLifecycleGatewayEngine r11, c r12, av r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        long r8 = System.currentTimeMillis();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L10;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15.next(), b.class, "com.obric.memorydata.plugin");
        r13.c().invalidateObservation(r0.a(), r0.b(), r8);     // Catch: SQLiteException -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: SQLiteException -> L8
    L8:
        r11.a(r12);
        throw new KotlinNothingValueException();
    }

    private final boolean a(c r6, av r7, b r8, bc r9) {
        bc r10 = (bc) ZeusTransformUtils.wrapperContextForParams(r9, bc.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, bc.c.class) == true) goto L15;
        return false;
    L15:
        bh r0 = r7.c().query(r8.a(), r8.b());     // Catch: SQLiteException -> L13
        if (r0 != null) goto L9;
        return false;
    L9:
        if (ap.a(r0, r10) == true) goto L11;
        return false;
    L11:
        b(r6, r7, r8, r10);
        return true;
    L13:
        a(r6);
        throw new KotlinNothingValueException();
    }

    private static final boolean a(IndexPendingLifecycleGatewayEngine r2, String r3, av r4, Set r5, Map r6) {
        return r2.a(r3, r4, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(String r5, final av r6, Set<b> r7) {
        final Set<b> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == false) goto L5;
        return true;
    L5:
        final c r9 = a(r5, MutationKind.INVALIDATE, c(r6.b(), r8), r8.size());
        r6.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$r9a183Y23aNg0zQXIuYlE_cNdQo(r8, this, r9, r6));     // Catch: LifecycleObservationFailure -> L8
        return true;
    L8:
        return false;
    }

    private final boolean a(String r9, final av r10, Set<b> r11, Map<b, ? extends List<bb>> r12) {
        final Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        final c r13 = a(r9, MutationKind.REPLAY_FINALIZE, 0, r5.size());
        boolean r14 = ((Boolean) ZeusTransformUtils.preCheckCast(r10.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$u9keitQR6Qitlbyg2Mu8EV3Y4hQ(this, r10, r5, r6, r13)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: LinkageError -> L7 RuntimeException -> L9 LifecycleObservationFailure -> L13 SQLiteException -> L11
        if (r14 == true) goto L6;
        b(r13);
    L6:
        return r14;
    L11:
        b(r13);
        return false;
    L7:
        b(r13);
        return false;
    L9:
        b(r13);
    L10:
        return false;
    }

    private final int b(IndexPendingDao r7, List<cd> r8) {
        IndexPendingDao r6 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r7, IndexPendingDao.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r10 = 0;
    L4:
        if (r9.hasNext() == false) goto L6;
        cd r1 = (cd) ZeusTransformUtils.preCheckCast(r9.next(), cd.class, "com.obric.memorydata.plugin");
        r10 = r10 + r6.deleteByIdAndTimestamp(r1.a(), r1.d());
        goto L4
    L6:
        return r10;
    }

    private final long b(bc r2) {
        bc r1 = (bc) ZeusTransformUtils.wrapperContextForParams(r2, bc.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, bc.c.class) == false) goto L6;
        return ((bc.c) ZeusTransformUtils.preCheckCast(r1, bc.c.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, bc.a.class) == false) goto L9;
        return ((bc.a) ZeusTransformUtils.preCheckCast(r1, bc.a.class, "com.obric.memorydata.plugin")).a();
    L9:
        if (Intrinsics.areEqual(r1, bc.b.f9410a) == false) goto L13;
        return 0;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private static final e b(Function0 r2) {
        return (e) ZeusTransformUtils.preCheckCast(((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke(), e.class, "com.obric.memorydata.plugin");
    }

    private final Map<b, List<bb>> b(IndexPendingDao r13, Set<b> r14) {
        IndexPendingDao r12 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r13, IndexPendingDao.class, "com.obric.memorydata.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r16 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16));
        Iterator r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L11;
        Object r2 = r17.next();
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r12.queryWithRawDb(r4.a(), r4.b()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        cd r8 = (cd) ZeusTransformUtils.preCheckCast(r7.next(), cd.class, "com.obric.memorydata.plugin");
        r6.add(new bb(r8.a(), r8.d()));
        goto L7
    L9:
        r3.put(r2, CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{IndexPendingLifecycleGatewayEngine$capturePendingState$1$2.INSTANCE, IndexPendingLifecycleGatewayEngine$capturePendingState$1$3.INSTANCE})));
        goto L4
    L11:
        return (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin");
    }

    private static final Unit b(String r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IndexPendingLifecycleGateway", r7, null, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit b(Set r2) {
        Intrinsics.checkNotNullParameter((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin"), "it");
        return Unit.INSTANCE;
    }

    private final void b(c r3) {
        this.c.invoke("lifecycle observation failure owner=" + r3.a() + " mutation=" + r3.b().name() + " pendingCount=" + r3.c() + " entityCount=" + r3.d());     // Catch: Throwable -> L4
        return;
    }

    private final void b(c r25, EntityIndexLifecycleDao r26, b r27) {
        EntityIndexLifecycleDao r0 = (EntityIndexLifecycleDao) ZeusTransformUtils.wrapperContextForParams(r26, EntityIndexLifecycleDao.class, "com.obric.memorydata.plugin");
        if (r0.query(r27.a(), r27.b()) == null) goto L16;
        return;
    L16:
        if (r0.insertIfAbsent(new bh(r27.a(), r27.b(), 0, 0, false, 1, 0, 0, 0, 0, 0, 0, 0, 8156, null)) != (-1)) goto L20;
        a(r25);
        throw new KotlinNothingValueException();
    L20:
        return;
    L11:
        a(r25);
        throw new KotlinNothingValueException();
    L14:
        a(r25);
        throw new KotlinNothingValueException();
    }

    private final void b(c r26, av r27, b r28, bc r29) {
        bc r3 = (bc) ZeusTransformUtils.wrapperContextForParams(r29, bc.class, "com.obric.memorydata.plugin");
        EntityIndexLifecycleDao r10 = r27.c();
        List<cd> r4 = r27.b().queryWithRawDb(r28.a(), r28.b());
        bh r11 = r10.query(r28.a(), r28.b());     // Catch: SQLiteException -> L43
        bc r5 = ap.a(r11, r3, r4);
        k r12 = a(r28, r4, r5);
        if (r11 != null) goto L16;
        if (r10.insertIfAbsent(a(r28, r5, r12)) == (-1)) goto L11;
        return;
    L11:
        a(r26);
        throw new KotlinNothingValueException();
    L13:
        a(r26);
        throw new KotlinNothingValueException();
    L16:
        if (r11.f() == Long.MAX_VALUE) goto L41;
        long r16 = b(r5);
        if (ap.a(r11, r5) == true) goto L45;
    L23:
        long r13 = r11.f() + 1;
        long r6 = r28.a();     // Catch: SQLiteException -> L39
        int r7 = r28.b();     // Catch: SQLiteException -> L39
        long r8 = r11.f();     // Catch: SQLiteException -> L39
        if (ZeusTransformUtils.instanceOf(r5, bc.c.class) == true) goto L27;
    L29:
        int r18 = 0;
    L31:
        if (ZeusTransformUtils.instanceOf(r5, bc.a.class) == true) goto L33;
    L35:
        int r19 = 0;
    L36:
        a(r26, r10.openRound(r6, r7, r8, r13, r16, r16, r16, r18, r19, r12.a(), r12.b(), r12.c(), r12.d()));
        return;
    L33:
        if (r11.c() != 0) goto L35;
        r19 = 1;
        goto L36
    L27:
        if (r16 <= r11.c()) goto L29;
        r18 = 1;
    L39:
        a(r26);
        throw new KotlinNothingValueException();
    L45:
        a(r26, r10.invalidateObservation(r28.a(), r28.b(), r16));
    L21:
        a(r26);
        throw new KotlinNothingValueException();
    L41:
        a(r26);
        throw new KotlinNothingValueException();
    L43:
        a(r26);
        throw new KotlinNothingValueException();
    }

    private final int c(IndexPendingDao r8, Set<b> r9) {
        IndexPendingDao r7 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r8, IndexPendingDao.class, "com.obric.memorydata.plugin");
        long r1 = 0;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: SQLiteException -> L9
    L5:
        if (r10.hasNext() == false) goto L7;
        b r11 = (b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L9
        r1 = r1 + RangesKt.coerceAtMost(r7.queryCountWithRawDb(r11.a(), r11.b()), 2147483647L);     // Catch: SQLiteException -> L9
        goto L5
    L7:
        return (int) RangesKt.coerceAtMost(r1, 2147483647L);
    L9:
        return 0;
    }

    private final long c(c r9, EntityIndexLifecycleDao r10, b r11) {
        EntityIndexLifecycleDao r0 = (EntityIndexLifecycleDao) ZeusTransformUtils.wrapperContextForParams(r10, EntityIndexLifecycleDao.class, "com.obric.memorydata.plugin");
        b(r9, r0, r11);
        bh r12 = r0.query(r11.a(), r11.b());     // Catch: SQLiteException -> L12
        if (r12 != null) goto L14;
        a(r9);
        throw new KotlinNothingValueException();
    L14:
        a(r9, r0.closeWithoutCompletion(r11.a(), r11.b(), r12.f(), r12.g()));
        return r12.f();
    L8:
        a(r9);
        throw new KotlinNothingValueException();
    L12:
        a(r9);
        throw new KotlinNothingValueException();
    }

    private final List<Long> c(IndexPendingDao r2, List<cd> r3) {
        IndexPendingDao r1 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, IndexPendingDao.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L6;
        return CollectionsKt.emptyList();
    L6:
        return r1.insertAll(r4);
    }

    private final Map<b, Long> d(IndexPendingDao r7, Set<b> r8) {
        IndexPendingDao r6 = (IndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r7, IndexPendingDao.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Object r1 = r11.next();
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
        r2.put(r1, Long.valueOf(r6.queryCountWithRawDb(r3.a(), r3.b())));
        goto L4
    L7:
        return (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$6OGfNbVkhgSrlSoKZApV2gsh_-w, reason: not valid java name */
    public static /* synthetic */ Unit m558lambda$6OGfNbVkhgSrlSoKZApV2gsh_w(String r0) {
        return b(r0);
    }

    public static /* synthetic */ e lambda$9tZBxlskqBkzqocIOHa_SGDNs9I(Function0 r0) {
        return b(r0);
    }

    public static /* synthetic */ d lambda$BTMzBAe9TlPOFqA93_60nRYw58Q(IndexPendingLifecycleGatewayEngine r0, String r1, LinkedHashSet r2, av r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$E1du4TUW-jBmeBc2FyyT4D86tO0, reason: not valid java name */
    public static /* synthetic */ e m559lambda$E1du4TUWjBmeBc2FyyT4D86tO0(IndexPendingLifecycleGatewayEngine r0, av r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d lambda$FSd8vHh3vJlzMmRAZOkKqakKaKg(IndexPendingLifecycleGatewayEngine r0, String r1, av r2, List r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ d lambda$Fof9ebw4SIreZ_uDJxNEan8jWEE(IndexPendingLifecycleGatewayEngine r0, String r1, av r2, List r3, List r4, bc r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ d lambda$G5y1K786QG7p7_oszs8LaQoCUHo(IndexPendingLifecycleGatewayEngine r0, String r1, av r2, List r3, bc r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$WKiWIR-jHEnieWf8823hGlCheGQ, reason: not valid java name */
    public static /* synthetic */ e m560lambda$WKiWIRjHEnieWf8823hGlCheGQ(IndexPendingLifecycleGatewayEngine r0, av r1, l r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ d lambda$WfzaItKgkSnkbJiVuKvmlFUUtiY(Function0 r0) {
        return a(r0);
    }

    public static /* synthetic */ e lambda$XjYzUTlhDQcKEg2E0kg6EogbSb4(av r0, cd r1, IndexPendingLifecycleGatewayEngine r2, b r3) {
        return a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$Y4x8hg3-OHdcM14lQSn4gGThteQ, reason: not valid java name */
    public static /* synthetic */ Boolean m561lambda$Y4x8hg3OHdcM14lQSn4gGThteQ(av r0, long r1, int r3, IndexPendingLifecycleGatewayEngine r4, c r5, Ref.ObjectRef r6, bc r7, long r8, long r10, Ref.ObjectRef r12) {
        return a(r0, r1, r3, r4, r5, r6, r7, r8, r10, r12);
    }

    public static /* synthetic */ u lambda$ZBCGY267Fp9dn5lrlhYZFNNLXUw(IndexPendingLifecycleGatewayEngine r0, String r1, av r2, long r3, long r5) {
        return a(r0, r1, r2, r3, r5);
    }

    public static /* synthetic */ d lambda$aJ6jbv5W_6nI3OoPjXh_G990StM(av r0, cd r1, IndexPendingLifecycleGatewayEngine r2, b r3, String r4, bc r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ e lambda$mg4ze7OpHa2p3e8jolj5aU8kMPI(IndexPendingLifecycleGatewayEngine r0, av r1, List r2, List r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ e lambda$oOIx23ls8NvlqfkufIpgFTcX5QU(IndexPendingLifecycleGatewayEngine r0, av r1, List r2, LinkedHashSet r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Object lambda$owJBdWbCXPHPUzFytO_MMPYKZAs(Function0 r0, g r1, IndexPendingLifecycleGatewayEngine r2, av r3, String r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean lambda$qbBsjQADTpXYtNQoEGU_c9__4w8(IndexPendingLifecycleGatewayEngine r0, String r1, av r2, Set r3, Map r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$r9a183Y23aNg0zQXIuYlE_cNdQo(Set r0, IndexPendingLifecycleGatewayEngine r1, c r2, av r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Boolean lambda$u9keitQR6Qitlbyg2Mu8EV3Y4hQ(IndexPendingLifecycleGatewayEngine r0, av r1, Set r2, Map r3, c r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$uZmD6G8ititeJUYZTUVRQeoMNjI(Set r0) {
        return b(r0);
    }

    public static /* synthetic */ e lambda$xdgOGqXtW6fGKNHybzXVakNpdnw(IndexPendingLifecycleGatewayEngine r0, av r1, LinkedHashSet r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ h lambda$ygfzR0FJHsQGXxf4gDdPujNsfU4(IndexPendingLifecycleGatewayEngine r0, av r1, l r2, long r3, boolean r5) {
        return a(r0, r1, r2, r3, r5);
    }

    public final az<Long> a(final String r12, final cd r13, bc r14) {
        final bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r14, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "ownerDbType");
        Intrinsics.checkNotNullParameter(r13, "pending");
        Intrinsics.checkNotNullParameter(r8, "startEvidence");
        a(r8);
        a(r12, (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(Integer.valueOf(r13.c())), Collection.class, "com.obric.memorydata.plugin"));
        final av r15 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r12), av.class, "com.obric.memorydata.plugin");
        final b r0 = a(r13);
        return a(r12, r15, GatewayTransactionMode.OWNED, new $$Lambda$IndexPendingLifecycleGatewayEngine$aJ6jbv5W_6nI3OoPjXh_G990StM(r15, r13, this, r0, r12, r8), new $$Lambda$IndexPendingLifecycleGatewayEngine$XjYzUTlhDQcKEg2E0kg6EogbSb4(r15, r13, this, r0));
    }

    public final az<Integer> a(final String r8, List<? extends ax> r9, GatewayTransactionMode r10) {
        final List<? extends ax> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "ownerDbType");
        Intrinsics.checkNotNullParameter(r11, "deletes");
        Intrinsics.checkNotNullParameter(r10, "transactionMode");
        a(r8, (Collection) ZeusTransformUtils.preCheckCast(a(r11), Collection.class, "com.obric.memorydata.plugin"));
        final av r3 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r8), av.class, "com.obric.memorydata.plugin");
        return a(r8, r3, r10, new $$Lambda$IndexPendingLifecycleGatewayEngine$FSd8vHh3vJlzMmRAZOkKqakKaKg(this, r8, r3, r11), new $$Lambda$IndexPendingLifecycleGatewayEngine$E1du4TUWjBmeBc2FyyT4D86tO0(this, r3, r11));
    }

    public final az<List<Long>> a(final String r14, List<cd> r15, bc r16, GatewayTransactionMode r17) {
        final List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        final bc r5 = (bc) ZeusTransformUtils.wrapperContextForParams(r16, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "ownerDbType");
        Intrinsics.checkNotNullParameter(r8, "pending");
        Intrinsics.checkNotNullParameter(r5, "startEvidence");
        Intrinsics.checkNotNullParameter(r17, "transactionMode");
        a(r5);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(Integer.valueOf(((cd) ZeusTransformUtils.preCheckCast(r1.next(), cd.class, "com.obric.memorydata.plugin")).c()));
        goto L4
    L6:
        a(r14, (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        final av r10 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r14), av.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r4.add(a((cd) ZeusTransformUtils.preCheckCast(r6.next(), cd.class, "com.obric.memorydata.plugin")));
        goto L8
    L10:
        final LinkedHashSet r11 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r4, LinkedHashSet.class, "com.obric.memorydata.plugin");
        return a(r14, r10, r17, new $$Lambda$IndexPendingLifecycleGatewayEngine$G5y1K786QG7p7_oszs8LaQoCUHo(this, r14, r10, r8, r5), new $$Lambda$IndexPendingLifecycleGatewayEngine$oOIx23ls8NvlqfkufIpgFTcX5QU(this, r10, r8, r11));
    }

    public final az<List<Long>> a(final String r11, List<? extends ax> r12, List<cd> r13, bc r14, GatewayTransactionMode r15) {
        final List<? extends ax> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        final List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        final bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r14, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "ownerDbType");
        Intrinsics.checkNotNullParameter(r16, "deletes");
        Intrinsics.checkNotNullParameter(r17, "replacement");
        Intrinsics.checkNotNullParameter(r8, "startEvidence");
        Intrinsics.checkNotNullParameter(r15, "transactionMode");
        a(r8);
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(a(r16), Collection.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(Integer.valueOf(((cd) ZeusTransformUtils.preCheckCast(r1.next(), cd.class, "com.obric.memorydata.plugin")).c()));
        goto L4
    L6:
        a(r11, (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r18, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        final av r19 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r11), av.class, "com.obric.memorydata.plugin");
        return a(r11, r19, r15, new $$Lambda$IndexPendingLifecycleGatewayEngine$Fof9ebw4SIreZ_uDJxNEan8jWEE(this, r11, r19, r16, r17, r8), new $$Lambda$IndexPendingLifecycleGatewayEngine$mg4ze7OpHa2p3e8jolj5aU8kMPI(this, r19, r16, r17));
    }

    public final az<Integer> a(final String r10, List<Long> r11, Set<Integer> r12, GatewayTransactionMode r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "ownerDbType");
        Intrinsics.checkNotNullParameter(r14, "rawDbIds");
        Intrinsics.checkNotNullParameter(r15, "entityTypes");
        Intrinsics.checkNotNullParameter(r13, "transactionMode");
        a(r10, (Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin"));
        final av r4 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r10), av.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L10;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r17.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r5.add(new b(((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.memorydata.plugin")).longValue(), r2));
        goto L7
    L9:
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L10:
        final LinkedHashSet r18 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r0, LinkedHashSet.class, "com.obric.memorydata.plugin");
        return a(r10, r4, r13, new $$Lambda$IndexPendingLifecycleGatewayEngine$BTMzBAe9TlPOFqA93_60nRYw58Q(this, r10, r18, r4), new $$Lambda$IndexPendingLifecycleGatewayEngine$xdgOGqXtW6fGKNHybzXVakNpdnw(this, r4, r18));
    }

    public final /* synthetic */ az a(String r12, List r13, Set r14, Set r15, List r16, bc r17) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        bc r6 = (bc) ZeusTransformUtils.wrapperContextForParams(r17, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "ownerDbType");
        Intrinsics.checkNotNullParameter(r0, "rawDbIds");
        Intrinsics.checkNotNullParameter(r3, "entityTypes");
        Intrinsics.checkNotNullParameter(r4, "buildTypes");
        Intrinsics.checkNotNullParameter(r5, "replacement");
        Intrinsics.checkNotNullParameter(r6, "startEvidence");
        a(r12);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r8.add(Integer.valueOf(((cd) ZeusTransformUtils.preCheckCast(r9.next(), cd.class, "com.obric.memorydata.plugin")).c()));
        goto L4
    L6:
        a(r12, (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (r0.isEmpty() == false) goto L9;
    L14:
        List r1 = CollectionsKt.emptyList();
    L16:
        return a(this, r12, r1, r5, r6, null, 16, null);
    L9:
        if (r3.isEmpty() == true) goto L14;
        if (r4.isEmpty() == true) goto L14;
        r1 = CollectionsKt.listOf(new ar(r0, r3, r4));
        goto L16
    }

    public final u a(final String r12, final long r13, final long r15) {
        Intrinsics.checkNotNullParameter(r12, "ownerDbType");
        a(r12);
        final av r3 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r12), av.class, "com.obric.memorydata.plugin");
        if ((!r3.a().inTransaction()) == false) goto L9;
        return (u) ZeusTransformUtils.preCheckCast(r3.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$ZBCGY267Fp9dn5lrlhYZFNNLXUw(this, r12, r3, r13, r15)), u.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    L9:
        throw new IllegalArgumentException("execution lease owns its transaction".toString());
    }

    public final v a(u r3, long r4) {
        u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "handle");
        return a(r5, r4, true);
    }

    public final <T> T a(final String r9, Function0<? extends T> r10) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "ownerDbType");
        Intrinsics.checkNotNullParameter(r3, "replayBody");
        a(r9);
        final av r6 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r9), av.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        if ((!r6.a().inTransaction()) == false) goto L19;
        if (this.e.get() == null) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L17;
        final g r11 = new g(r9);
        this.e.set(r11);
        T r12 = (T) r6.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$owJBdWbCXPHPUzFytO_MMPYKZAs(r3, r11, this, r6, r9));
        r11.b().b();     // Catch: Throwable -> L13
        this.e.remove();
        return r12;
    L13:
        th = move-exception;
        this.e.remove();
        throw th;
    L17:
        throw new IllegalStateException("pending-only replay wrappers cannot be nested".toString());
    L19:
        throw new IllegalStateException("pending-only replay wrapper owns the complete owner transaction".toString());
    }

    public final boolean a(ba r2) {
        ba r1 = (ba) ZeusTransformUtils.wrapperContextForParams(r2, ba.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "receipt");
        if (ZeusTransformUtils.instanceOf(r1, o.class) == false) goto L5;
        o r3 = (o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.a();
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, com.obric.memorydata.database.index.bc, java.lang.Object] */
    public final boolean a(String r22, final long r23, final int r25, final long r26, bc r28) {
        final ?? r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r28, bc.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r22, "ownerDbType");
        Intrinsics.checkNotNullParameter(r8, "startEvidence");
        a(r8);
        a(r22, (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(Integer.valueOf(r25)), Collection.class, "com.obric.memorydata.plugin"));
        if (IndexDashboardCoverageV1Policy.f9304a.a(r25) == false) goto L30;
        if (r26 <= 0) goto L30;
        final av r1 = (av) ZeusTransformUtils.preCheckCast(this.d.invoke(r22), av.class, "com.obric.memorydata.plugin");
        if ((!r1.a().inTransaction()) == false) goto L28;
        final c r12 = a(r22, MutationKind.INSERT, 0, 1);
        final long r16 = System.currentTimeMillis();
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = r8;
    L38:
        boolean r18 = false;
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r1.a().runInTransaction(new $$Lambda$IndexPendingLifecycleGatewayEngine$Y4x8hg3OHdcM14lQSn4gGThteQ(r1, r23, r25, this, r12, r7, r8, r26, r16, r9)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L31 LifecycleObservationFailure -> L32
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(r9.element, Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31 LifecycleObservationFailure -> L32
        if (r0 == null) goto L39;
        ah.f9339a.a(r25, ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue(), IndexExecutionOutcome.TERMINAL_SUCCESS);     // Catch: Throwable -> L31 LifecycleObservationFailure -> L32
    L40:
        return r11;
    L39:
        return r11;
    L20:
        IndexPendingLifecycleGatewayEngine r2 = this;
    L23:
        r2.b(r12);
    L26:
        return r18;
    L19:
        r18 = false;
    L17:
        r18 = false;
    L18:
        r18 = false;
    L24:
        r18 = false;
    L22:
        r18 = false;
        r2 = this;
    L21:
        r18 = false;
        r2 = this;
        goto L23
    L28:
        throw new IllegalStateException("coverage-only round owns its transaction".toString());
    L30:
        return false;
    }

    public final v b(u r3, long r4) {
        u r5 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "handle");
        return a(r5, r4, false);
    }
}
