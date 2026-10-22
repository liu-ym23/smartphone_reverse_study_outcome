package com.obric.memorydata.memory.island.obric;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.ColorHex;
import com.obric.livecard.api.entity.ColorToken;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.utils.ResourceUtils;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.memory.island.BatchMemoryIslandKind;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.memory.ui.detail.t;
import com.obric.memorydata.memory.ui.list.MemoryContainerTab;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.obric.memorydata.memory.ui.list.PersonalTag;
import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.memory.utils.q;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.memory.State;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils;", "", "<init>", "()V", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IslandSessionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f10217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<IslandSession> f10218b = null;
    private static String c;
    private static Companion.b d;
    private static Companion.MemoryExpandTemplateType e;
    private static bx f;
    private static final o g = null;
    private static long h;
    private static final al i = null;
    private static final Function0<Unit> j = null;
    private static final Function1<Continuation<? super Unit>, Object> k = null;
    private static Long l;

    @Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001: È\u0001É\u0001Ê\u0001Ë\u0001Ì\u0001Í\u0001Î\u0001Ï\u0001Ð\u0001Ñ\u0001Ò\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001×\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u000bH\u0002J=\u00108\u001a\u0002092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b@JI\u0010A\u001a\u00020B2\u0006\u00107\u001a\u00020;2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0002\bIJ7\u0010J\u001a\u00020K2\n\b\u0002\u00107\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010DH\u0000¢\u0006\u0002\bNJI\u0010O\u001a\u00020P2\u0006\u00107\u001a\u00020;2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0002\bQJ\u0006\u0010R\u001a\u000201J\u001d\u0010S\u001a\u00020T*\u00020\u00012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0014\u0010Z\u001a\u00020B*\u00020K2\u0006\u0010[\u001a\u00020\\H\u0002J>\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u00010\u000b2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0a2\u0006\u0010[\u001a\u00020\\2\u0006\u0010b\u001a\u00020VH\u0002J\b\u0010c\u001a\u00020\rH\u0002J\f\u0010d\u001a\u00020\\*\u00020\u0001H\u0002JA\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u00172\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010mJ8\u0010n\u001a\u00020f2\u0006\u0010g\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u00172\u0006\u0010l\u001a\u00020\u0017H\u0002J$\u0010o\u001a\u00020>2\u0006\u0010g\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\u00172\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0005H\u0002J$\u0010p\u001a\u00020>2\u0006\u0010g\u001a\u00020\u00172\u0006\u0010h\u001a\u00020\u00172\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010q\u001a\u000201*\u00020\u00012\u0006\u0010F\u001a\u00020\u0001H\u0002J \u0010r\u001a\u0002012\u0006\u0010s\u001a\u0002092\u0006\u0010_\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\H\u0002J7\u0010t\u001a\u000201*\u00020\b2\b\u0010u\u001a\u0004\u0018\u00010T2\u0006\u0010v\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u00052\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010xJ\u0014\u0010y\u001a\u000201*\u00020\b2\u0006\u0010[\u001a\u00020\\H\u0002J \u0010z\u001a\u000201*\u00020T2\u0012\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0aH\u0002J\u0018\u0010|\u001a\u0002012\u0006\u00107\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u0005H\u0002Jq\u0010~\u001a\u0002012\u0006\u0010i\u001a\u00020\u00052\u0006\u0010s\u001a\u0002092\u0006\u0010_\u001a\u00020\u00012\u0006\u0010\u007f\u001a\u00020V2\t\b\u0002\u0010\u0080\u0001\u001a\u00020V2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0a2\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010+2\t\b\u0002\u0010\u0082\u0001\u001a\u00020V¢\u0006\u0003\u0010\u0083\u0001J\u001b\u0010\u0086\u0001\u001a\u0002012\t\b\u0002\u0010\u0087\u0001\u001a\u00020+H\u0086@¢\u0006\u0003\u0010\u0088\u0001J\u0010\u0010\u0089\u0001\u001a\u000201H\u0086@¢\u0006\u0003\u0010\u008a\u0001J/\u0010\u008b\u0001\u001a\u0002012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\f\b\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010DJ\u0018\u0010\u008b\u0001\u001a\u0002012\u0006\u00107\u001a\u00020\u000bH\u0086@¢\u0006\u0003\u0010\u0091\u0001JL\u0010\u0092\u0001\u001a\u0002012\u0006\u0010i\u001a\u00020\u00052\u0007\u0010\u0093\u0001\u001a\u00020\u00172\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\b\b\u0002\u0010\u007f\u001a\u00020V2\u0010\b\u0002\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010DJ\u000f\u0010\u0094\u0001\u001a\u0002012\u0006\u0010i\u001a\u00020\u0005J$\u0010\u0095\u0001\u001a\u0002012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u00172\b\b\u0002\u0010\u007f\u001a\u00020VJ\u0011\u0010\u0098\u0001\u001a\u0002012\u0006\u0010i\u001a\u00020\u0005H\u0002JA\u0010\u0099\u0001\u001a\u0002012\u0006\u0010i\u001a\u00020\u00052\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\f\b\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010D2\u0006\u0010\u007f\u001a\u00020VH\u0002J\u001b\u0010\u009a\u0001\u001a\u0002012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u0010\u007f\u001a\u00020VH\u0002J\u0015\u0010\u009b\u0001\u001a\t\u0012\u0005\u0012\u00030\u009c\u00010D*\u00030\u0097\u0001H\u0002J#\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u0001*\u000b\u0012\u0005\u0012\u00030\u009e\u0001\u0018\u00010D2\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0002J\u0014\u0010¡\u0001\u001a\u00020\u0005*\t\u0012\u0005\u0012\u00030\u009c\u00010DH\u0002J\u0017\u0010¢\u0001\u001a\u00020\u0005*\u00030\u009c\u00012\u0007\u0010£\u0001\u001a\u00020\u0005H\u0002J\u0017\u0010¤\u0001\u001a\u00020\u0005*\u00030\u009c\u00012\u0007\u0010¥\u0001\u001a\u00020\u0005H\u0002J\u0017\u0010¦\u0001\u001a\u00020M*\u00030\u009c\u00012\u0007\u0010¥\u0001\u001a\u00020\u0005H\u0002J\u001e\u0010§\u0001\u001a\u00020\u000b*\u00030\u009c\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010DH\u0002J\u0012\u0010¨\u0001\u001a\u00020\u00052\u0007\u0010©\u0001\u001a\u00020\u0017H\u0002J.\u0010ª\u0001\u001a\u00020;2\u0007\u0010«\u0001\u001a\u00020\u00052\u0007\u0010¬\u0001\u001a\u00020\u00172\u0007\u0010\u00ad\u0001\u001a\u00020\u00172\b\u0010®\u0001\u001a\u00030¯\u0001H\u0002J\u0016\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\b\u0010®\u0001\u001a\u00030¯\u0001H\u0002J\f\u0010²\u0001\u001a\u0005\u0018\u00010±\u0001H\u0002J,\u0010³\u0001\u001a\u0005\u0018\u00010±\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00012\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0000¢\u0006\u0003\b·\u0001J6\u0010¸\u0001\u001a\u00020;2\u0007\u0010«\u0001\u001a\u00020\u00052\u0007\u0010¬\u0001\u001a\u00020\u00172\u0007\u0010¹\u0001\u001a\u00020\u00052\n\u0010º\u0001\u001a\u0005\u0018\u00010±\u0001H\u0000¢\u0006\u0003\b»\u0001JL\u0010¼\u0001\u001a\u00020E2\u0006\u0010h\u001a\u00020\u00172\u0006\u0010g\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u00052\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00052\f\b\u0002\u0010½\u0001\u001a\u0005\u0018\u00010±\u00012\t\b\u0002\u0010¾\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0003\b¿\u0001J\u000e\u0010À\u0001\u001a\u00020\u0005*\u00030\u008d\u0001H\u0002J\u000e\u0010Á\u0001\u001a\u00020\u0005*\u00030 \u0001H\u0002J\u000f\u0010Â\u0001\u001a\u00030Ã\u0001*\u00030 \u0001H\u0002J1\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\u000e\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010DH\u0002J\u0019\u0010Å\u0001\u001a\u0002012\u0006\u0010i\u001a\u00020\u00052\u0006\u0010\u007f\u001a\u00020VH\u0002J\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u000bJ\u0007\u0010Ç\u0001\u001a\u000201R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00102\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020104\u0012\u0006\u0012\u0004\u0018\u00010\u000103X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u0014\u0010\u0084\u0001\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u0085\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion;", "", "<init>", "()V", "TAG", "", "islandSession", "", "Lcom/obric/livecard/api/entity/IslandSession;", "currentId", "currentContent", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$IslandContent;", "currentExpandTemplateType", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryExpandTemplateType;", "job", "Lkotlinx/coroutines/Job;", "islandSessionMutex", "Lcom/obric/memorydata/memory/utils/ReentrantMutex;", "COLLAPSE_ICON_ID", "EXPAND_ICON_ID", "EVENT_PLAY_LOTTIE", "EVENT_PAUSE_LOTTIE", "MEMORY_VIDEO_INITIAL_FRAME", "", "MEMORY_VIDEO_LAST_FRAME", "EXPAND_VIDEO_SCALE", "", "COLLAPSE_ICON_SIZE", "EXPAND_VIDEO_ICON_SIZE", "EXPAND_PROGRESS_STATIC_ICON_SIZE", "EXPAND_STATIC_ICON_SIZE", "EXPAND_STATUS_TEXT_SIZE", "EXPAND_SUCCESS_STATUS_TEXT_SIZE", "EXPAND_MESSAGE_CONTENT_TEXT_SIZE", "EXPAND_MESSAGE_TITLE_TEXT_SIZE", "SYSTEM_APPLET_PROVIDER_AUTHORITY", "METHOD_GET_AI_PACKAGE_INFO", "KEY_PACKAGE_NAME", "KEY_APP_ID", "KEY_RESULT", "ISLAND_APPLET_PACKAGE_NAME", "MEMORY_BATCH_EXPAND_APP_ID", "lastUpdateTs", "", "SHOW_TIME_DELTA", "scope", "Lkotlinx/coroutines/CoroutineScope;", "CARD_CLICK_CALLBACK", "Lkotlin/Function0;", "", "ON_DISMISS_CALLBACK", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/jvm/functions/Function1;", "openIslandContent", Params.CONTENT, "buildMemoryCollapseTemplate", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryCollapseTemplate;", "endText", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "startText", "endIcon", "Lcom/obric/livecard/api/entity/Icon;", "startIcon", "buildMemoryCollapseTemplate$memory_obricRelease", "buildMemoryExpandedTemplate", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryExpandedTemplate;", "buttons", "", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleIconButton;", "icon", "title", "titleIcon", "buildMemoryExpandedTemplate$memory_obricRelease", "buildMemoryBatchExpandedTemplate", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryBatchExpandedTemplate;", "messageList", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryBatchMessage;", "buildMemoryBatchExpandedTemplate$memory_obricRelease", "buildCompatibleCommonExpandedTemplate", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleCommonExpandedTemplate;", "buildCompatibleCommonExpandedTemplate$memory_obricRelease", "showEffect", "createExpandWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Object;Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "isAppletTemplateSupported", "appId", "toLegacyExpandedTemplate", "visualState", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIslandVisualState;", "resolveExpandTemplate", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$ResolvedExpandTemplate;", "expandWidgetData", "batchActionContents", "", "isUpdate", "selectExpandTemplateType", "resolveMemoryIslandVisualState", "memoryVideoIcon", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIcon;", "width", "height", OaidModel.KEY_ID, "autoplay", "loop", "position", "(IILjava/lang/String;IILjava/lang/Integer;)Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIcon;", "memoryExpandedVideoIcon", "memoryStaticIcon", "memoryInProgressStaticIcon", "applyMemoryExpandIcon", "configureMemoryIslandIcon", "collapseWidgetData", "sendLottieEventSafely", "targetWidget", "eventId", "iconId", "(Lcom/obric/livecard/api/entity/IslandSession;Lcom/obric/livecard/api/entity/IslandWidget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "syncMemoryLottieState", "registerBatchActionCallbacks", "actionContents", "handleIslandContentClick", InfoRequestQPSOptTraceLogger.REASON, "showIslandWidget", "needEffect", "needDismiss", "dismissInterval", "isCancellation", "(Ljava/lang/String;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryCollapseTemplate;Ljava/lang/Object;ZZLcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$IslandContent;Ljava/util/Map;Ljava/lang/Long;Z)V", "cancellationDeadline", "Ljava/lang/Long;", "autoDismiss", "delayMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCalendar", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "calendars", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$IslandContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMemory", "state", "showMemoryCancelled", "showBatchMemorySummary", "summary", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandSummary;", "onPassiveMemoryFailed", "onPassiveMemorySuccess", "onBatchMemorySuccess", "toIslandGroups", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandGroup;", "toIslandGroup", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandItem;", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;", "toDisplayContent", "toDisplayLine", AnnotatedPrivateKey.LABEL, "toBatchActionId", "batchId", "toBatchMessage", "toIslandContent", "memoryIslandTextColor", "colorRes", "compatibleText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "legacyTextSize", "legacyColorRes", "colorRole", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIslandTextColor;", "memoryIslandTextColorToken", "Lcom/obric/livecard/api/entity/ColorToken;", "memorySuccessIconColor", "buildColorToken", "blend", "Lcom/obric/livecard/api/entity/ColorHex;", "fluid", "buildColorToken$memory_obricRelease", "buildCompatibleText", "legacyColor", TypedValues.Custom.S_COLOR, "buildCompatibleText$memory_obricRelease", "compatibleIconButton", "foregroundColor", "latestIcon", "compatibleIconButton$memory_obricRelease", "batchTitle", "defaultTitle", "toMemoryTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "transformEntity2Content", "onPassiveMemoryBegin", "getCurrentContent", "clearCurrentContent", "IslandContent", "CalendarButton", "CalendarExpandedTemplate", "MemoryCollapseTemplate", "MemoryExpandedTemplate", "MemoryBatchExpandedTemplate", "MemoryBatchMessage", "CompatibleText", "CompatibleCommonExpandedTemplate", "MemoryIcon", "LegacyIconButtonPayload", "CompatibleIconButton", "ResolvedExpandTemplate", "MemoryExpandTemplateType", "MemoryIslandVisualState", "MemoryIslandTextColor", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CalendarButton;", "", OaidModel.KEY_ID, "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getText", "setText", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CalendarButton {
            private ColorToken color;
            private String id;
            private String text;

            public CalendarButton() {
                this(null, null, null, 7, null);
            }

            public CalendarButton(String r1, String r2, ColorToken r3) {
                this.id = r1;
                this.text = r2;
                this.color = r3;
            }

            public /* synthetic */ CalendarButton(String r2, String r3, ColorToken r4, int r5, DefaultConstructorMarker r6) {
                if ((r5 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r5 & 4) == 0) goto L11;
                r4 = null;
            L11:
                this(r2, r3, r4);
            }

            public static /* synthetic */ CalendarButton copy$default(CalendarButton r0, String r1, String r2, ColorToken r3, int r4, Object r5) {
                if ((r4 & 1) == 0) goto L6;
                r1 = r0.id;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r2 = r0.text;
            L9:
                if ((r4 & 4) == 0) goto L12;
                r3 = r0.color;
            L12:
                return r0.copy(r1, r2, r3);
            }

            public final String component1() {
                return this.id;
            }

            public final String component2() {
                return this.text;
            }

            public final ColorToken component3() {
                return this.color;
            }

            public final CalendarButton copy(String r1, String r2, ColorToken r3) {
                return new CalendarButton(r1, r2, r3);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, CalendarButton.class) == true) goto L8;
                return false;
            L8:
                CalendarButton r6 = (CalendarButton) ZeusTransformUtils.preCheckCast(r5, CalendarButton.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.color, r6.color) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final ColorToken getColor() {
                return this.color;
            }

            public final String getId() {
                return this.id;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String r0 = this.id;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                String r4 = this.text;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                ColorToken r7 = this.color;
                if (r7 == null) goto L15;
                r1 = r7.hashCode();
            L15:
                return r6 + r1;
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final void setColor(ColorToken r1) {
                this.color = r1;
            }

            public final void setId(String r1) {
                this.id = r1;
            }

            public final void setText(String r1) {
                this.text = r1;
            }

            public String toString() {
                return "CalendarButton(id=" + this.id + ", text=" + this.text + ", color=" + this.color + ')';
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CalendarExpandedTemplate;", "", "title", "", "type", "left_btn", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CalendarButton;", "right_btn", "location", OaidModel.KEY_TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CalendarButton;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CalendarButton;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "setType", "getLeft_btn", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CalendarButton;", "setLeft_btn", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CalendarButton;)V", "getRight_btn", "setRight_btn", "getLocation", "setLocation", "getTime", "setTime", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CalendarExpandedTemplate {
            private CalendarButton left_btn;
            private String location;
            private CalendarButton right_btn;
            private String time;
            private String title;
            private String type;

            public CalendarExpandedTemplate(String r2, String r3, CalendarButton r4, CalendarButton r5, String r6, String r7) {
                Intrinsics.checkNotNullParameter(r2, "title");
                Intrinsics.checkNotNullParameter(r3, "type");
                Intrinsics.checkNotNullParameter(r4, "left_btn");
                Intrinsics.checkNotNullParameter(r5, "right_btn");
                this.title = r2;
                this.type = r3;
                this.left_btn = r4;
                this.right_btn = r5;
                this.location = r6;
                this.time = r7;
            }

            public /* synthetic */ CalendarExpandedTemplate(String r10, String r11, CalendarButton r12, CalendarButton r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
                if ((r16 & 16) == 0) goto L5;
                String r7 = null;
            L7:
                if ((r16 & 32) == 0) goto L9;
                String r8 = null;
            L10:
                this(r10, r11, r12, r13, r7, r8);
                return;
            L9:
                r8 = r15;
                goto L10
            L5:
                r7 = r14;
                goto L7
            }

            public static /* synthetic */ CalendarExpandedTemplate copy$default(CalendarExpandedTemplate r4, String r5, String r6, CalendarButton r7, CalendarButton r8, String r9, String r10, int r11, Object r12) {
                if ((r11 & 1) == 0) goto L6;
                r5 = r4.title;
            L6:
                if ((r11 & 2) == 0) goto L8;
                r6 = r4.type;
            L8:
                String r13 = r6;
                if ((r11 & 4) == 0) goto L11;
                r7 = r4.left_btn;
            L11:
                CalendarButton r0 = r7;
                if ((r11 & 8) == 0) goto L14;
                r8 = r4.right_btn;
            L14:
                CalendarButton r1 = r8;
                if ((r11 & 16) == 0) goto L17;
                r9 = r4.location;
            L17:
                String r2 = r9;
                if ((r11 & 32) == 0) goto L20;
                r10 = r4.time;
            L20:
                String r14 = r5;
                return r4.copy(r14, r13, r0, r1, r2, r10);
            }

            public static /* synthetic */ IslandWidget create$default(CalendarExpandedTemplate r0, Boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = false;
            L6:
                return r0.create(r1);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.type;
            }

            public final CalendarButton component3() {
                return this.left_btn;
            }

            public final CalendarButton component4() {
                return this.right_btn;
            }

            public final String component5() {
                return this.location;
            }

            public final String component6() {
                return this.time;
            }

            public final CalendarExpandedTemplate copy(String r8, String r9, CalendarButton r10, CalendarButton r11, String r12, String r13) {
                Intrinsics.checkNotNullParameter(r8, "title");
                Intrinsics.checkNotNullParameter(r9, "type");
                Intrinsics.checkNotNullParameter(r10, "left_btn");
                Intrinsics.checkNotNullParameter(r11, "right_btn");
                return new CalendarExpandedTemplate(r8, r9, r10, r11, r12, r13);
            }

            public final IslandWidget create(Boolean r14) {
                return new IslandWidget("com.obric.island_applet:memory_showinfo_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, CalendarExpandedTemplate.class) == true) goto L8;
                return false;
            L8:
                CalendarExpandedTemplate r6 = (CalendarExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, CalendarExpandedTemplate.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.left_btn, r6.left_btn) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.right_btn, r6.right_btn) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.location, r6.location) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.time, r6.time) == true) goto L26;
                return false;
            L26:
                return true;
            }

            public final CalendarButton getLeft_btn() {
                return this.left_btn;
            }

            public final String getLocation() {
                return this.location;
            }

            public final CalendarButton getRight_btn() {
                return this.right_btn;
            }

            public final String getTime() {
                return this.time;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                int r0 = ((((((this.title.hashCode() * 31) + this.type.hashCode()) * 31) + this.left_btn.hashCode()) * 31) + this.right_btn.hashCode()) * 31;
                String r1 = this.location;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                String r5 = this.time;
                if (r5 == null) goto L11;
                r2 = r5.hashCode();
            L11:
                return r4 + r2;
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final void setLeft_btn(CalendarButton r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.left_btn = r2;
            }

            public final void setLocation(String r1) {
                this.location = r1;
            }

            public final void setRight_btn(CalendarButton r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.right_btn = r2;
            }

            public final void setTime(String r1) {
                this.time = r1;
            }

            public final void setTitle(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.title = r2;
            }

            public final void setType(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.type = r2;
            }

            public String toString() {
                return "CalendarExpandedTemplate(title=" + this.title + ", type=" + this.type + ", left_btn=" + this.left_btn + ", right_btn=" + this.right_btn + ", location=" + this.location + ", time=" + this.time + ')';
            }
        }

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003Jg\u00101\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0001J\u0013\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleCommonExpandedTemplate;", "", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", Params.CONTENT, "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "icon", "Lcom/obric/livecard/api/entity/Icon;", "title", "titleIcon", "iconButtonList", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$LegacyIconButtonPayload;", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Lcom/obric/livecard/api/entity/Icon;Ljava/util/List;Ljava/util/List;)V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getContent", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "setContent", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;)V", "getIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getTitle", "setTitle", "getTitleIcon", "setTitleIcon", "getIconButtonList", "setIconButtonList", "getButtonV2List", "setButtonV2List", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CompatibleCommonExpandedTemplate {
            private List<Button> buttonList;
            private List<ButtonV2> buttonV2List;
            private CompatibleText content;
            private Icon icon;
            private List<LegacyIconButtonPayload> iconButtonList;
            private CompatibleText title;
            private Icon titleIcon;

            public CompatibleCommonExpandedTemplate(List<Button> r3, CompatibleText r4, Icon r5, CompatibleText r6, Icon r7, List<LegacyIconButtonPayload> r8, List<ButtonV2> r9) {
                List<Button> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                List<LegacyIconButtonPayload> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
                List<ButtonV2> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r10, "buttonList");
                Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r11, "iconButtonList");
                Intrinsics.checkNotNullParameter(r12, "buttonV2List");
                this.buttonList = r10;
                this.content = r4;
                this.icon = r5;
                this.title = r6;
                this.titleIcon = r7;
                this.iconButtonList = r11;
                this.buttonV2List = r12;
            }

            public /* synthetic */ CompatibleCommonExpandedTemplate(List r12, CompatibleText r13, Icon r14, CompatibleText r15, Icon r16, List r17, List r18, int r19, DefaultConstructorMarker r20) {
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
                List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
                if ((r19 & 1) == 0) goto L5;
                r0 = CollectionsKt.emptyList();
            L5:
                List r4 = r0;
                if ((r19 & 4) == 0) goto L8;
                Icon r6 = null;
            L10:
                if ((r19 & 8) == 0) goto L12;
                CompatibleText r7 = null;
            L14:
                if ((r19 & 16) == 0) goto L16;
                Icon r8 = null;
            L18:
                if ((r19 & 32) == 0) goto L20;
                r2 = CollectionsKt.emptyList();
            L20:
                List r9 = r2;
                if ((r19 & 64) == 0) goto L23;
                r1 = CollectionsKt.emptyList();
            L23:
                this(r4, r13, r6, r7, r8, r9, r1);
                return;
            L16:
                r8 = r16;
                goto L18
            L12:
                r7 = r15;
                goto L14
            L8:
                r6 = r14;
                goto L10
            }

            public static /* synthetic */ CompatibleCommonExpandedTemplate copy$default(CompatibleCommonExpandedTemplate r9, List r10, CompatibleText r11, Icon r12, CompatibleText r13, Icon r14, List r15, List r16, int r17, Object r18) {
                List<Button> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
                List<LegacyIconButtonPayload> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
                List<ButtonV2> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
                if ((r17 & 1) == 0) goto L6;
                r1 = r9.buttonList;
            L6:
                if ((r17 & 2) == 0) goto L8;
                CompatibleText r4 = r9.content;
            L10:
                if ((r17 & 4) == 0) goto L12;
                Icon r5 = r9.icon;
            L14:
                if ((r17 & 8) == 0) goto L16;
                CompatibleText r6 = r9.title;
            L18:
                if ((r17 & 16) == 0) goto L20;
                Icon r7 = r9.titleIcon;
            L22:
                if ((r17 & 32) == 0) goto L25;
                r3 = r9.iconButtonList;
            L25:
                if ((r17 & 64) == 0) goto L28;
                r2 = r9.buttonV2List;
            L28:
                return r9.copy(r1, r4, r5, r6, r7, r3, r2);
            L20:
                r7 = r14;
                goto L22
            L16:
                r6 = r13;
                goto L18
            L12:
                r5 = r12;
                goto L14
            L8:
                r4 = r11;
                goto L10
            }

            public static /* synthetic */ IslandWidget create$default(CompatibleCommonExpandedTemplate r0, Boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = false;
            L6:
                return r0.create(r1);
            }

            public final List<Button> component1() {
                return this.buttonList;
            }

            public final CompatibleText component2() {
                return this.content;
            }

            public final Icon component3() {
                return this.icon;
            }

            public final CompatibleText component4() {
                return this.title;
            }

            public final Icon component5() {
                return this.titleIcon;
            }

            public final List<LegacyIconButtonPayload> component6() {
                return this.iconButtonList;
            }

            public final List<ButtonV2> component7() {
                return this.buttonV2List;
            }

            public final CompatibleCommonExpandedTemplate copy(List<Button> r11, CompatibleText r12, Icon r13, CompatibleText r14, Icon r15, List<LegacyIconButtonPayload> r16, List<ButtonV2> r17) {
                List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
                List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
                List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "buttonList");
                Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r8, "iconButtonList");
                Intrinsics.checkNotNullParameter(r9, "buttonV2List");
                return new CompatibleCommonExpandedTemplate(r3, r12, r13, r14, r15, r8, r9);
            }

            public final IslandWidget create(Boolean r14) {
                return new IslandWidget("com.obric.island_applet:common_expand_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, CompatibleCommonExpandedTemplate.class) == true) goto L8;
                return false;
            L8:
                CompatibleCommonExpandedTemplate r6 = (CompatibleCommonExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, CompatibleCommonExpandedTemplate.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.buttonList, r6.buttonList) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.titleIcon, r6.titleIcon) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.iconButtonList, r6.iconButtonList) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.buttonV2List, r6.buttonV2List) == true) goto L29;
                return false;
            L29:
                return true;
            }

            public final List<Button> getButtonList() {
                return this.buttonList;
            }

            public final List<ButtonV2> getButtonV2List() {
                return this.buttonV2List;
            }

            public final CompatibleText getContent() {
                return this.content;
            }

            public final Icon getIcon() {
                return this.icon;
            }

            public final List<LegacyIconButtonPayload> getIconButtonList() {
                return this.iconButtonList;
            }

            public final CompatibleText getTitle() {
                return this.title;
            }

            public final Icon getTitleIcon() {
                return this.titleIcon;
            }

            public int hashCode() {
                int r0 = ((this.buttonList.hashCode() * 31) + this.content.hashCode()) * 31;
                Icon r1 = this.icon;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                CompatibleText r5 = this.title;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                Icon r8 = this.titleIcon;
                if (r8 == null) goto L15;
                r2 = r8.hashCode();
            L15:
                return ((((r7 + r2) * 31) + this.iconButtonList.hashCode()) * 31) + this.buttonV2List.hashCode();
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final void setButtonList(List<Button> r3) {
                List<Button> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "<set-?>");
                this.buttonList = r4;
            }

            public final void setButtonV2List(List<ButtonV2> r3) {
                List<ButtonV2> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "<set-?>");
                this.buttonV2List = r4;
            }

            public final void setContent(CompatibleText r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.content = r2;
            }

            public final void setIcon(Icon r1) {
                this.icon = r1;
            }

            public final void setIconButtonList(List<LegacyIconButtonPayload> r3) {
                List<LegacyIconButtonPayload> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "<set-?>");
                this.iconButtonList = r4;
            }

            public final void setTitle(CompatibleText r1) {
                this.title = r1;
            }

            public final void setTitleIcon(Icon r1) {
                this.titleIcon = r1;
            }

            public String toString() {
                return "CompatibleCommonExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ", iconButtonList=" + this.iconButtonList + ", buttonV2List=" + this.buttonV2List + ')';
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003Jh\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0005HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00067"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "textSize", "", "textColor", "textLightColor", "fontWeight", "maskedText", "lineHeight", TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getTextSize", "()I", "setTextSize", "(I)V", "getTextColor", "setTextColor", "getTextLightColor", "setTextLightColor", "getFontWeight", "setFontWeight", "getMaskedText", "setMaskedText", "getLineHeight", "()Ljava/lang/Integer;", "setLineHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CompatibleText {
            private ColorToken color;
            private String fontWeight;
            private Integer lineHeight;
            private String maskedText;
            private String text;
            private String textColor;
            private String textLightColor;
            private int textSize;

            public CompatibleText(String r2, int r3, String r4, String r5, String r6, String r7, Integer r8, ColorToken r9) {
                Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
                Intrinsics.checkNotNullParameter(r4, "textColor");
                this.text = r2;
                this.textSize = r3;
                this.textColor = r4;
                this.textLightColor = r5;
                this.fontWeight = r6;
                this.maskedText = r7;
                this.lineHeight = r8;
                this.color = r9;
            }

            public /* synthetic */ CompatibleText(String r9, int r10, String r11, String r12, String r13, String r14, Integer r15, ColorToken r16, int r17, DefaultConstructorMarker r18) {
                if ((r17 & 2) == 0) goto L5;
                int r1 = 0;
            L7:
                if ((r17 & 4) == 0) goto L9;
                String r2 = "";
            L10:
                ColorToken r4 = null;
                if ((r17 & 8) == 0) goto L13;
                String r3 = null;
            L15:
                if ((r17 & 16) == 0) goto L17;
                String r5 = null;
            L19:
                if ((r17 & 32) == 0) goto L21;
                String r6 = null;
            L23:
                if ((r17 & 64) == 0) goto L25;
                Integer r7 = null;
            L27:
                if ((r17 & 128) != 0) goto L30;
                r4 = r16;
            L30:
                this(r9, r1, r2, r3, r5, r6, r7, r4);
                return;
            L25:
                r7 = r15;
                goto L27
            L21:
                r6 = r14;
                goto L23
            L17:
                r5 = r13;
                goto L19
            L13:
                r3 = r12;
                goto L15
            L9:
                r2 = r11;
                goto L10
            L5:
                r1 = r10;
                goto L7
            }

            public static /* synthetic */ CompatibleText copy$default(CompatibleText r9, String r10, int r11, String r12, String r13, String r14, String r15, Integer r16, ColorToken r17, int r18, Object r19) {
                if ((r18 & 1) == 0) goto L5;
                String r2 = r9.text;
            L7:
                if ((r18 & 2) == 0) goto L9;
                int r3 = r9.textSize;
            L11:
                if ((r18 & 4) == 0) goto L13;
                String r4 = r9.textColor;
            L15:
                if ((r18 & 8) == 0) goto L17;
                String r5 = r9.textLightColor;
            L19:
                if ((r18 & 16) == 0) goto L21;
                String r6 = r9.fontWeight;
            L23:
                if ((r18 & 32) == 0) goto L25;
                String r7 = r9.maskedText;
            L27:
                if ((r18 & 64) == 0) goto L29;
                Integer r8 = r9.lineHeight;
            L31:
                if ((r18 & 128) == 0) goto L33;
                ColorToken r1 = r9.color;
            L35:
                return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
            L33:
                r1 = r17;
                goto L35
            L29:
                r8 = r16;
                goto L31
            L25:
                r7 = r15;
                goto L27
            L21:
                r6 = r14;
                goto L23
            L17:
                r5 = r13;
                goto L19
            L13:
                r4 = r12;
                goto L15
            L9:
                r3 = r11;
                goto L11
            L5:
                r2 = r10;
                goto L7
            }

            public final String component1() {
                return this.text;
            }

            public final int component2() {
                return this.textSize;
            }

            public final String component3() {
                return this.textColor;
            }

            public final String component4() {
                return this.textLightColor;
            }

            public final String component5() {
                return this.fontWeight;
            }

            public final String component6() {
                return this.maskedText;
            }

            public final Integer component7() {
                return this.lineHeight;
            }

            public final ColorToken component8() {
                return this.color;
            }

            public final CompatibleText copy(String r11, int r12, String r13, String r14, String r15, String r16, Integer r17, ColorToken r18) {
                Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
                Intrinsics.checkNotNullParameter(r13, "textColor");
                return new CompatibleText(r11, r12, r13, r14, r15, r16, r17, r18);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, CompatibleText.class) == true) goto L8;
                return false;
            L8:
                CompatibleText r6 = (CompatibleText) ZeusTransformUtils.preCheckCast(r5, CompatibleText.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
                return false;
            L12:
                if (this.textSize == r6.textSize) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.textLightColor, r6.textLightColor) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.fontWeight, r6.fontWeight) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.maskedText, r6.maskedText) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.lineHeight, r6.lineHeight) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.areEqual(this.color, r6.color) == true) goto L32;
                return false;
            L32:
                return true;
            }

            public final ColorToken getColor() {
                return this.color;
            }

            public final String getFontWeight() {
                return this.fontWeight;
            }

            public final Integer getLineHeight() {
                return this.lineHeight;
            }

            public final String getMaskedText() {
                return this.maskedText;
            }

            public final String getText() {
                return this.text;
            }

            public final String getTextColor() {
                return this.textColor;
            }

            public final String getTextLightColor() {
                return this.textLightColor;
            }

            public final int getTextSize() {
                return this.textSize;
            }

            public int hashCode() {
                int r0 = ((((this.text.hashCode() * 31) + Integer.hashCode(this.textSize)) * 31) + this.textColor.hashCode()) * 31;
                String r1 = this.textLightColor;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                String r5 = this.fontWeight;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                String r8 = this.maskedText;
                if (r8 != null) goto L13;
                int r9 = 0;
            L14:
                int r10 = (r7 + r9) * 31;
                Integer r11 = this.lineHeight;
                if (r11 != null) goto L17;
                int r12 = 0;
            L18:
                int r13 = (r10 + r12) * 31;
                ColorToken r14 = this.color;
                if (r14 == null) goto L23;
                r2 = r14.hashCode();
            L23:
                return r13 + r2;
            L17:
                r12 = r11.hashCode();
                goto L18
            L13:
                r9 = r8.hashCode();
                goto L14
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final void setColor(ColorToken r1) {
                this.color = r1;
            }

            public final void setFontWeight(String r1) {
                this.fontWeight = r1;
            }

            public final void setLineHeight(Integer r1) {
                this.lineHeight = r1;
            }

            public final void setMaskedText(String r1) {
                this.maskedText = r1;
            }

            public final void setText(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.text = r2;
            }

            public final void setTextColor(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.textColor = r2;
            }

            public final void setTextLightColor(String r1) {
                this.textLightColor = r1;
            }

            public final void setTextSize(int r1) {
                this.textSize = r1;
            }

            public String toString() {
                return "CompatibleText(text=" + this.text + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ", maskedText=" + this.maskedText + ", lineHeight=" + this.lineHeight + ", color=" + this.color + ')';
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003Jl\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$LegacyIconButtonPayload;", "", "icon", "", "height", "", "width", OaidModel.KEY_ID, "dismissKeyguard", "", "backgroundIcon", "iconLight", TypedValues.Custom.S_COLOR, "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getWidth", "setWidth", "getId", "setId", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getBackgroundIcon", "setBackgroundIcon", "getIconLight", "setIconLight", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$LegacyIconButtonPayload;", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class LegacyIconButtonPayload {
            private String backgroundIcon;
            private ColorToken color;
            private Boolean dismissKeyguard;
            private Integer height;
            private String icon;
            private String iconLight;
            private String id;
            private Integer width;

            public LegacyIconButtonPayload(String r2, Integer r3, Integer r4, String r5, Boolean r6, String r7, String r8, ColorToken r9) {
                Intrinsics.checkNotNullParameter(r2, "icon");
                this.icon = r2;
                this.height = r3;
                this.width = r4;
                this.id = r5;
                this.dismissKeyguard = r6;
                this.backgroundIcon = r7;
                this.iconLight = r8;
                this.color = r9;
            }

            public /* synthetic */ LegacyIconButtonPayload(String r9, Integer r10, Integer r11, String r12, Boolean r13, String r14, String r15, ColorToken r16, int r17, DefaultConstructorMarker r18) {
                ColorToken r2 = null;
                if ((r17 & 2) == 0) goto L5;
                Integer r1 = null;
            L7:
                if ((r17 & 4) == 0) goto L9;
                Integer r3 = null;
            L11:
                if ((r17 & 8) == 0) goto L13;
                String r4 = null;
            L15:
                if ((r17 & 16) == 0) goto L17;
                Boolean r5 = null;
            L19:
                if ((r17 & 32) == 0) goto L21;
                String r6 = null;
            L23:
                if ((r17 & 64) == 0) goto L25;
                String r7 = null;
            L27:
                if ((r17 & 128) != 0) goto L30;
                r2 = r16;
            L30:
                this(r9, r1, r3, r4, r5, r6, r7, r2);
                return;
            L25:
                r7 = r15;
                goto L27
            L21:
                r6 = r14;
                goto L23
            L17:
                r5 = r13;
                goto L19
            L13:
                r4 = r12;
                goto L15
            L9:
                r3 = r11;
                goto L11
            L5:
                r1 = r10;
                goto L7
            }

            public static /* synthetic */ LegacyIconButtonPayload copy$default(LegacyIconButtonPayload r9, String r10, Integer r11, Integer r12, String r13, Boolean r14, String r15, String r16, ColorToken r17, int r18, Object r19) {
                if ((r18 & 1) == 0) goto L5;
                String r2 = r9.icon;
            L7:
                if ((r18 & 2) == 0) goto L9;
                Integer r3 = r9.height;
            L11:
                if ((r18 & 4) == 0) goto L13;
                Integer r4 = r9.width;
            L15:
                if ((r18 & 8) == 0) goto L17;
                String r5 = r9.id;
            L19:
                if ((r18 & 16) == 0) goto L21;
                Boolean r6 = r9.dismissKeyguard;
            L23:
                if ((r18 & 32) == 0) goto L25;
                String r7 = r9.backgroundIcon;
            L27:
                if ((r18 & 64) == 0) goto L29;
                String r8 = r9.iconLight;
            L31:
                if ((r18 & 128) == 0) goto L33;
                ColorToken r1 = r9.color;
            L35:
                return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
            L33:
                r1 = r17;
                goto L35
            L29:
                r8 = r16;
                goto L31
            L25:
                r7 = r15;
                goto L27
            L21:
                r6 = r14;
                goto L23
            L17:
                r5 = r13;
                goto L19
            L13:
                r4 = r12;
                goto L15
            L9:
                r3 = r11;
                goto L11
            L5:
                r2 = r10;
                goto L7
            }

            public final String component1() {
                return this.icon;
            }

            public final Integer component2() {
                return this.height;
            }

            public final Integer component3() {
                return this.width;
            }

            public final String component4() {
                return this.id;
            }

            public final Boolean component5() {
                return this.dismissKeyguard;
            }

            public final String component6() {
                return this.backgroundIcon;
            }

            public final String component7() {
                return this.iconLight;
            }

            public final ColorToken component8() {
                return this.color;
            }

            public final LegacyIconButtonPayload copy(String r11, Integer r12, Integer r13, String r14, Boolean r15, String r16, String r17, ColorToken r18) {
                Intrinsics.checkNotNullParameter(r11, "icon");
                return new LegacyIconButtonPayload(r11, r12, r13, r14, r15, r16, r17, r18);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, LegacyIconButtonPayload.class) == true) goto L8;
                return false;
            L8:
                LegacyIconButtonPayload r6 = (LegacyIconButtonPayload) ZeusTransformUtils.preCheckCast(r5, LegacyIconButtonPayload.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r6.height) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.width, r6.width) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.id, r6.id) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.backgroundIcon, r6.backgroundIcon) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.iconLight, r6.iconLight) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.areEqual(this.color, r6.color) == true) goto L32;
                return false;
            L32:
                return true;
            }

            public final String getBackgroundIcon() {
                return this.backgroundIcon;
            }

            public final ColorToken getColor() {
                return this.color;
            }

            public final Boolean getDismissKeyguard() {
                return this.dismissKeyguard;
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getIconLight() {
                return this.iconLight;
            }

            public final String getId() {
                return this.id;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public int hashCode() {
                int r0 = this.icon.hashCode() * 31;
                Integer r1 = this.height;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Integer r5 = this.width;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                String r8 = this.id;
                if (r8 != null) goto L13;
                int r9 = 0;
            L14:
                int r10 = (r7 + r9) * 31;
                Boolean r11 = this.dismissKeyguard;
                if (r11 != null) goto L17;
                int r12 = 0;
            L18:
                int r13 = (r10 + r12) * 31;
                String r14 = this.backgroundIcon;
                if (r14 != null) goto L21;
                int r15 = 0;
            L22:
                int r16 = (r13 + r15) * 31;
                String r17 = this.iconLight;
                if (r17 != null) goto L25;
                int r18 = 0;
            L26:
                int r19 = (r16 + r18) * 31;
                ColorToken r20 = this.color;
                if (r20 == null) goto L31;
                r2 = r20.hashCode();
            L31:
                return r19 + r2;
            L25:
                r18 = r17.hashCode();
                goto L26
            L21:
                r15 = r14.hashCode();
                goto L22
            L17:
                r12 = r11.hashCode();
                goto L18
            L13:
                r9 = r8.hashCode();
                goto L14
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final void setBackgroundIcon(String r1) {
                this.backgroundIcon = r1;
            }

            public final void setColor(ColorToken r1) {
                this.color = r1;
            }

            public final void setDismissKeyguard(Boolean r1) {
                this.dismissKeyguard = r1;
            }

            public final void setHeight(Integer r1) {
                this.height = r1;
            }

            public final void setIcon(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.icon = r2;
            }

            public final void setIconLight(String r1) {
                this.iconLight = r1;
            }

            public final void setId(String r1) {
                this.id = r1;
            }

            public final void setWidth(Integer r1) {
                this.width = r1;
            }

            public String toString() {
                return "LegacyIconButtonPayload(icon=" + this.icon + ", height=" + this.height + ", width=" + this.width + ", id=" + this.id + ", dismissKeyguard=" + this.dismissKeyguard + ", backgroundIcon=" + this.backgroundIcon + ", iconLight=" + this.iconLight + ", color=" + this.color + ')';
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryBatchExpandedTemplate;", "", Params.CONTENT, "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "icon", "messageList", "", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryBatchMessage;", "<init>", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Ljava/lang/Object;Ljava/util/List;)V", "getContent", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "setContent", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;)V", "getIcon", "()Ljava/lang/Object;", "setIcon", "(Ljava/lang/Object;)V", "getMessageList", "()Ljava/util/List;", "setMessageList", "(Ljava/util/List;)V", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MemoryBatchExpandedTemplate {
            private CompatibleText content;
            private Object icon;
            private List<MemoryBatchMessage> messageList;

            public MemoryBatchExpandedTemplate() {
                this(null, null, null, 7, null);
            }

            public MemoryBatchExpandedTemplate(CompatibleText r3, Object r4, List<MemoryBatchMessage> r5) {
                List<MemoryBatchMessage> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                this.content = r3;
                this.icon = r4;
                this.messageList = r6;
            }

            public /* synthetic */ MemoryBatchExpandedTemplate(CompatibleText r2, Object r3, List r4, int r5, DefaultConstructorMarker r6) {
                List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                if ((r5 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r5 & 4) == 0) goto L11;
                r7 = null;
            L11:
                this(r2, r3, r7);
            }

            public static /* synthetic */ MemoryBatchExpandedTemplate copy$default(MemoryBatchExpandedTemplate r1, CompatibleText r2, Object r3, List r4, int r5, Object r6) {
                List<MemoryBatchMessage> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                if ((r5 & 1) == 0) goto L6;
                r2 = r1.content;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = r1.icon;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r7 = r1.messageList;
            L12:
                return r1.copy(r2, r3, r7);
            }

            public static /* synthetic */ IslandWidget create$default(MemoryBatchExpandedTemplate r0, Boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = false;
            L6:
                return r0.create(r1);
            }

            public final CompatibleText component1() {
                return this.content;
            }

            public final Object component2() {
                return this.icon;
            }

            public final List<MemoryBatchMessage> component3() {
                return this.messageList;
            }

            public final MemoryBatchExpandedTemplate copy(CompatibleText r2, Object r3, List<MemoryBatchMessage> r4) {
                return new MemoryBatchExpandedTemplate(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
            }

            public final IslandWidget create(Boolean r14) {
                return new IslandWidget("com.obric.island_applet:memory_batch_expand_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, MemoryBatchExpandedTemplate.class) == true) goto L8;
                return false;
            L8:
                MemoryBatchExpandedTemplate r6 = (MemoryBatchExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, MemoryBatchExpandedTemplate.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.messageList, r6.messageList) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final CompatibleText getContent() {
                return this.content;
            }

            public final Object getIcon() {
                return this.icon;
            }

            public final List<MemoryBatchMessage> getMessageList() {
                return this.messageList;
            }

            public int hashCode() {
                CompatibleText r0 = this.content;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                Object r4 = this.icon;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                List<MemoryBatchMessage> r7 = this.messageList;
                if (r7 == null) goto L15;
                r1 = r7.hashCode();
            L15:
                return r6 + r1;
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final void setContent(CompatibleText r1) {
                this.content = r1;
            }

            public final void setIcon(Object r1) {
                this.icon = r1;
            }

            public final void setMessageList(List<MemoryBatchMessage> r3) {
                this.messageList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            }

            public String toString() {
                return "MemoryBatchExpandedTemplate(content=" + this.content + ", icon=" + this.icon + ", messageList=" + this.messageList + ')';
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryBatchMessage;", "", OaidModel.KEY_ID, "", Params.CONTENT, "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "title", "messageNum", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getContent", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "setContent", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;)V", "getTitle", "setTitle", "getMessageNum", "setMessageNum", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MemoryBatchMessage {
            private CompatibleText content;
            private String id;
            private CompatibleText messageNum;
            private CompatibleText title;

            public MemoryBatchMessage() {
                this(null, null, null, null, 15, null);
            }

            public MemoryBatchMessage(String r1, CompatibleText r2, CompatibleText r3, CompatibleText r4) {
                this.id = r1;
                this.content = r2;
                this.title = r3;
                this.messageNum = r4;
            }

            public /* synthetic */ MemoryBatchMessage(String r2, CompatibleText r3, CompatibleText r4, CompatibleText r5, int r6, DefaultConstructorMarker r7) {
                if ((r6 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r6 & 4) == 0) goto L12;
                r4 = null;
            L12:
                if ((r6 & 8) == 0) goto L14;
                r5 = null;
            L14:
                this(r2, r3, r4, r5);
            }

            public static /* synthetic */ MemoryBatchMessage copy$default(MemoryBatchMessage r0, String r1, CompatibleText r2, CompatibleText r3, CompatibleText r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.id;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.content;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.title;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.messageNum;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public final String component1() {
                return this.id;
            }

            public final CompatibleText component2() {
                return this.content;
            }

            public final CompatibleText component3() {
                return this.title;
            }

            public final CompatibleText component4() {
                return this.messageNum;
            }

            public final MemoryBatchMessage copy(String r1, CompatibleText r2, CompatibleText r3, CompatibleText r4) {
                return new MemoryBatchMessage(r1, r2, r3, r4);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, MemoryBatchMessage.class) == true) goto L8;
                return false;
            L8:
                MemoryBatchMessage r6 = (MemoryBatchMessage) ZeusTransformUtils.preCheckCast(r5, MemoryBatchMessage.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.messageNum, r6.messageNum) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final CompatibleText getContent() {
                return this.content;
            }

            public final String getId() {
                return this.id;
            }

            public final CompatibleText getMessageNum() {
                return this.messageNum;
            }

            public final CompatibleText getTitle() {
                return this.title;
            }

            public int hashCode() {
                String r0 = this.id;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                CompatibleText r4 = this.content;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                CompatibleText r7 = this.title;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                CompatibleText r10 = this.messageNum;
                if (r10 == null) goto L19;
                r1 = r10.hashCode();
            L19:
                return r9 + r1;
            L13:
                r8 = r7.hashCode();
                goto L14
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final void setContent(CompatibleText r1) {
                this.content = r1;
            }

            public final void setId(String r1) {
                this.id = r1;
            }

            public final void setMessageNum(CompatibleText r1) {
                this.messageNum = r1;
            }

            public final void setTitle(CompatibleText r1) {
                this.title = r1;
            }

            public String toString() {
                return "MemoryBatchMessage(id=" + this.id + ", content=" + this.content + ", title=" + this.title + ", messageNum=" + this.messageNum + ')';
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006("}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryCollapseTemplate;", "", "endIcon", "Lcom/obric/livecard/api/entity/Icon;", "endText", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "startIcon", "startText", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Ljava/lang/Object;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;)V", "getEndIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setEndIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getEndText", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "setEndText", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;)V", "getStartIcon", "()Ljava/lang/Object;", "setStartIcon", "(Ljava/lang/Object;)V", "getStartText", "setStartText", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MemoryCollapseTemplate {
            private Icon endIcon;
            private CompatibleText endText;
            private Object startIcon;
            private CompatibleText startText;

            public MemoryCollapseTemplate() {
                this(null, null, null, null, 15, null);
            }

            public MemoryCollapseTemplate(Icon r1, CompatibleText r2, Object r3, CompatibleText r4) {
                this.endIcon = r1;
                this.endText = r2;
                this.startIcon = r3;
                this.startText = r4;
            }

            public /* synthetic */ MemoryCollapseTemplate(Icon r2, CompatibleText r3, Object r4, CompatibleText r5, int r6, DefaultConstructorMarker r7) {
                if ((r6 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r6 & 4) == 0) goto L12;
                r4 = null;
            L12:
                if ((r6 & 8) == 0) goto L14;
                r5 = null;
            L14:
                this(r2, r3, r4, r5);
            }

            public static /* synthetic */ MemoryCollapseTemplate copy$default(MemoryCollapseTemplate r0, Icon r1, CompatibleText r2, Object r3, CompatibleText r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.endIcon;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.endText;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.startIcon;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.startText;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public static /* synthetic */ IslandWidget create$default(MemoryCollapseTemplate r0, Boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = false;
            L6:
                return r0.create(r1);
            }

            public final Icon component1() {
                return this.endIcon;
            }

            public final CompatibleText component2() {
                return this.endText;
            }

            public final Object component3() {
                return this.startIcon;
            }

            public final CompatibleText component4() {
                return this.startText;
            }

            public final MemoryCollapseTemplate copy(Icon r1, CompatibleText r2, Object r3, CompatibleText r4) {
                return new MemoryCollapseTemplate(r1, r2, r3, r4);
            }

            public final IslandWidget create(Boolean r14) {
                return new IslandWidget("com.obric.island_applet:memory_collapse_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, MemoryCollapseTemplate.class) == true) goto L8;
                return false;
            L8:
                MemoryCollapseTemplate r6 = (MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(r5, MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.endIcon, r6.endIcon) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.endText, r6.endText) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.startIcon, r6.startIcon) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.startText, r6.startText) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final Icon getEndIcon() {
                return this.endIcon;
            }

            public final CompatibleText getEndText() {
                return this.endText;
            }

            public final Object getStartIcon() {
                return this.startIcon;
            }

            public final CompatibleText getStartText() {
                return this.startText;
            }

            public int hashCode() {
                Icon r0 = this.endIcon;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                CompatibleText r4 = this.endText;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                Object r7 = this.startIcon;
                if (r7 != null) goto L13;
                int r8 = 0;
            L14:
                int r9 = (r6 + r8) * 31;
                CompatibleText r10 = this.startText;
                if (r10 == null) goto L19;
                r1 = r10.hashCode();
            L19:
                return r9 + r1;
            L13:
                r8 = r7.hashCode();
                goto L14
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final void setEndIcon(Icon r1) {
                this.endIcon = r1;
            }

            public final void setEndText(CompatibleText r1) {
                this.endText = r1;
            }

            public final void setStartIcon(Object r1) {
                this.startIcon = r1;
            }

            public final void setStartText(CompatibleText r1) {
                this.startText = r1;
            }

            public String toString() {
                return "MemoryCollapseTemplate(endIcon=" + this.endIcon + ", endText=" + this.endText + ", startIcon=" + this.startIcon + ", startText=" + this.startText + ')';
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryExpandTemplateType;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "BATCH", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final enum MemoryExpandTemplateType extends Enum<MemoryExpandTemplateType> {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ MemoryExpandTemplateType[] $VALUES = null;
            public static final MemoryExpandTemplateType BATCH = null;
            public static final MemoryExpandTemplateType LEGACY = null;

            private static final /* synthetic */ MemoryExpandTemplateType[] $values() {
                return new MemoryExpandTemplateType[]{LEGACY, BATCH};
            }

            static {
                LEGACY = new MemoryExpandTemplateType("LEGACY", 0);
                BATCH = new MemoryExpandTemplateType("BATCH", 1);
                MemoryExpandTemplateType[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            }

            private MemoryExpandTemplateType(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumEntries<MemoryExpandTemplateType> getEntries() {
                return $ENTRIES;
            }

            public static MemoryExpandTemplateType valueOf(String r2) {
                return (MemoryExpandTemplateType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryExpandTemplateType.class, r2), MemoryExpandTemplateType.class, "com.obric.memorydata.plugin");
            }

            public static MemoryExpandTemplateType[] values() {
                return (MemoryExpandTemplateType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryExpandTemplateType[].class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010'\u001a\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010+J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003Jg\u00103\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0001J\u0013\u00104\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014¨\u0006:"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryExpandedTemplate;", "", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", Params.CONTENT, "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "icon", "title", "titleIcon", "Lcom/obric/livecard/api/entity/Icon;", "iconButtonList", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$LegacyIconButtonPayload;", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Ljava/lang/Object;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;Lcom/obric/livecard/api/entity/Icon;Ljava/util/List;Ljava/util/List;)V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getContent", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;", "setContent", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleText;)V", "getIcon", "()Ljava/lang/Object;", "setIcon", "(Ljava/lang/Object;)V", "getTitle", "setTitle", "getTitleIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setTitleIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getIconButtonList", "setIconButtonList", "getButtonV2List", "setButtonV2List", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MemoryExpandedTemplate {
            private List<Button> buttonList;
            private List<ButtonV2> buttonV2List;
            private CompatibleText content;
            private Object icon;
            private List<LegacyIconButtonPayload> iconButtonList;
            private CompatibleText title;
            private Icon titleIcon;

            public MemoryExpandedTemplate(List<Button> r3, CompatibleText r4, Object r5, CompatibleText r6, Icon r7, List<LegacyIconButtonPayload> r8, List<ButtonV2> r9) {
                List<Button> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                List<LegacyIconButtonPayload> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
                List<ButtonV2> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r10, "buttonList");
                Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r11, "iconButtonList");
                Intrinsics.checkNotNullParameter(r12, "buttonV2List");
                this.buttonList = r10;
                this.content = r4;
                this.icon = r5;
                this.title = r6;
                this.titleIcon = r7;
                this.iconButtonList = r11;
                this.buttonV2List = r12;
            }

            public /* synthetic */ MemoryExpandedTemplate(List r11, CompatibleText r12, Object r13, CompatibleText r14, Icon r15, List r16, List r17, int r18, DefaultConstructorMarker r19) {
                List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
                List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
                if ((r18 & 4) == 0) goto L5;
                Object r5 = null;
            L7:
                if ((r18 & 8) == 0) goto L9;
                CompatibleText r6 = null;
            L11:
                if ((r18 & 16) == 0) goto L13;
                Icon r7 = null;
            L15:
                if ((r18 & 32) == 0) goto L17;
                r0 = CollectionsKt.emptyList();
            L17:
                List r8 = r0;
                if ((r18 & 64) == 0) goto L20;
                List r9 = CollectionsKt.emptyList();
            L21:
                this(r3, r12, r5, r6, r7, r8, r9);
                return;
            L20:
                r9 = r1;
                goto L21
            L13:
                r7 = r15;
                goto L15
            L9:
                r6 = r14;
                goto L11
            L5:
                r5 = r13;
                goto L7
            }

            public static /* synthetic */ MemoryExpandedTemplate copy$default(MemoryExpandedTemplate r9, List r10, CompatibleText r11, Object r12, CompatibleText r13, Icon r14, List r15, List r16, int r17, Object r18) {
                List<Button> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
                List<LegacyIconButtonPayload> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
                List<ButtonV2> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
                if ((r17 & 1) == 0) goto L6;
                r1 = r9.buttonList;
            L6:
                if ((r17 & 2) == 0) goto L8;
                CompatibleText r4 = r9.content;
            L10:
                if ((r17 & 4) == 0) goto L12;
                Object r5 = r9.icon;
            L14:
                if ((r17 & 8) == 0) goto L16;
                CompatibleText r6 = r9.title;
            L18:
                if ((r17 & 16) == 0) goto L20;
                Icon r7 = r9.titleIcon;
            L22:
                if ((r17 & 32) == 0) goto L25;
                r3 = r9.iconButtonList;
            L25:
                if ((r17 & 64) == 0) goto L28;
                r2 = r9.buttonV2List;
            L28:
                return r9.copy(r1, r4, r5, r6, r7, r3, r2);
            L20:
                r7 = r14;
                goto L22
            L16:
                r6 = r13;
                goto L18
            L12:
                r5 = r12;
                goto L14
            L8:
                r4 = r11;
                goto L10
            }

            public static /* synthetic */ IslandWidget create$default(MemoryExpandedTemplate r0, Boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = false;
            L6:
                return r0.create(r1);
            }

            public final List<Button> component1() {
                return this.buttonList;
            }

            public final CompatibleText component2() {
                return this.content;
            }

            public final Object component3() {
                return this.icon;
            }

            public final CompatibleText component4() {
                return this.title;
            }

            public final Icon component5() {
                return this.titleIcon;
            }

            public final List<LegacyIconButtonPayload> component6() {
                return this.iconButtonList;
            }

            public final List<ButtonV2> component7() {
                return this.buttonV2List;
            }

            public final MemoryExpandedTemplate copy(List<Button> r11, CompatibleText r12, Object r13, CompatibleText r14, Icon r15, List<LegacyIconButtonPayload> r16, List<ButtonV2> r17) {
                List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
                List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
                List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "buttonList");
                Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r8, "iconButtonList");
                Intrinsics.checkNotNullParameter(r9, "buttonV2List");
                return new MemoryExpandedTemplate(r3, r12, r13, r14, r15, r8, r9);
            }

            public final IslandWidget create(Boolean r14) {
                return new IslandWidget("com.obric.island_applet:memory_expand_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, MemoryExpandedTemplate.class) == true) goto L8;
                return false;
            L8:
                MemoryExpandedTemplate r6 = (MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.buttonList, r6.buttonList) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.titleIcon, r6.titleIcon) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.iconButtonList, r6.iconButtonList) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.buttonV2List, r6.buttonV2List) == true) goto L29;
                return false;
            L29:
                return true;
            }

            public final List<Button> getButtonList() {
                return this.buttonList;
            }

            public final List<ButtonV2> getButtonV2List() {
                return this.buttonV2List;
            }

            public final CompatibleText getContent() {
                return this.content;
            }

            public final Object getIcon() {
                return this.icon;
            }

            public final List<LegacyIconButtonPayload> getIconButtonList() {
                return this.iconButtonList;
            }

            public final CompatibleText getTitle() {
                return this.title;
            }

            public final Icon getTitleIcon() {
                return this.titleIcon;
            }

            public int hashCode() {
                int r0 = ((this.buttonList.hashCode() * 31) + this.content.hashCode()) * 31;
                Object r1 = this.icon;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                CompatibleText r5 = this.title;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                Icon r8 = this.titleIcon;
                if (r8 == null) goto L15;
                r2 = r8.hashCode();
            L15:
                return ((((r7 + r2) * 31) + this.iconButtonList.hashCode()) * 31) + this.buttonV2List.hashCode();
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final void setButtonList(List<Button> r3) {
                List<Button> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "<set-?>");
                this.buttonList = r4;
            }

            public final void setButtonV2List(List<ButtonV2> r3) {
                List<ButtonV2> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "<set-?>");
                this.buttonV2List = r4;
            }

            public final void setContent(CompatibleText r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.content = r2;
            }

            public final void setIcon(Object r1) {
                this.icon = r1;
            }

            public final void setIconButtonList(List<LegacyIconButtonPayload> r3) {
                List<LegacyIconButtonPayload> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "<set-?>");
                this.iconButtonList = r4;
            }

            public final void setTitle(CompatibleText r1) {
                this.title = r1;
            }

            public final void setTitleIcon(Icon r1) {
                this.titleIcon = r1;
            }

            public String toString() {
                return "MemoryExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ", iconButtonList=" + this.iconButtonList + ", buttonV2List=" + this.buttonV2List + ')';
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b4\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ~\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\f2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\t\u0010A\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001f¨\u0006B"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIcon;", "", "height", "", "width", "icon", "", "loop", "autoplay", OaidModel.KEY_ID, "backgroundIcon", "useBorderRadius", "", "scale", "", "position", "<init>", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Double;Ljava/lang/Integer;)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getLoop", "()Ljava/lang/Integer;", "setLoop", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAutoplay", "setAutoplay", "getId", "setId", "getBackgroundIcon", "setBackgroundIcon", "getUseBorderRadius", "()Z", "setUseBorderRadius", "(Z)V", "getScale", "()Ljava/lang/Double;", "setScale", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getPosition", "setPosition", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Double;Ljava/lang/Integer;)Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIcon;", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MemoryIcon {
            private Integer autoplay;
            private String backgroundIcon;
            private int height;
            private String icon;
            private String id;
            private Integer loop;
            private Integer position;
            private Double scale;
            private boolean useBorderRadius;
            private int width;

            public MemoryIcon(int r2, int r3, String r4, Integer r5, Integer r6, String r7, String r8, boolean r9, Double r10, Integer r11) {
                Intrinsics.checkNotNullParameter(r4, "icon");
                this.height = r2;
                this.width = r3;
                this.icon = r4;
                this.loop = r5;
                this.autoplay = r6;
                this.id = r7;
                this.backgroundIcon = r8;
                this.useBorderRadius = r9;
                this.scale = r10;
                this.position = r11;
            }

            public /* synthetic */ MemoryIcon(int r15, int r16, String r17, Integer r18, Integer r19, String r20, String r21, boolean r22, Double r23, Integer r24, int r25, DefaultConstructorMarker r26) {
                if ((r25 & 8) == 0) goto L5;
                Integer r7 = null;
            L7:
                if ((r25 & 16) == 0) goto L9;
                Integer r8 = null;
            L11:
                if ((r25 & 32) == 0) goto L13;
                String r9 = null;
            L15:
                if ((r25 & 64) == 0) goto L17;
                String r10 = null;
            L19:
                if ((r25 & 128) == 0) goto L21;
                boolean r11 = false;
            L23:
                if ((r25 & 256) == 0) goto L25;
                Double r12 = null;
            L27:
                if ((r25 & 512) == 0) goto L29;
                Integer r13 = null;
            L30:
                this(r15, r16, r17, r7, r8, r9, r10, r11, r12, r13);
                return;
            L29:
                r13 = r24;
                goto L30
            L25:
                r12 = r23;
                goto L27
            L21:
                r11 = r22;
                goto L23
            L17:
                r10 = r21;
                goto L19
            L13:
                r9 = r20;
                goto L15
            L9:
                r8 = r19;
                goto L11
            L5:
                r7 = r18;
                goto L7
            }

            public static /* synthetic */ MemoryIcon copy$default(MemoryIcon r11, int r12, int r13, String r14, Integer r15, Integer r16, String r17, String r18, boolean r19, Double r20, Integer r21, int r22, Object r23) {
                if ((r22 & 1) == 0) goto L5;
                int r2 = r11.height;
            L7:
                if ((r22 & 2) == 0) goto L9;
                int r3 = r11.width;
            L11:
                if ((r22 & 4) == 0) goto L13;
                String r4 = r11.icon;
            L15:
                if ((r22 & 8) == 0) goto L17;
                Integer r5 = r11.loop;
            L19:
                if ((r22 & 16) == 0) goto L21;
                Integer r6 = r11.autoplay;
            L23:
                if ((r22 & 32) == 0) goto L25;
                String r7 = r11.id;
            L27:
                if ((r22 & 64) == 0) goto L29;
                String r8 = r11.backgroundIcon;
            L31:
                if ((r22 & 128) == 0) goto L33;
                boolean r9 = r11.useBorderRadius;
            L35:
                if ((r22 & 256) == 0) goto L37;
                Double r10 = r11.scale;
            L39:
                if ((r22 & 512) == 0) goto L41;
                Integer r1 = r11.position;
            L43:
                return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
            L41:
                r1 = r21;
                goto L43
            L37:
                r10 = r20;
                goto L39
            L33:
                r9 = r19;
                goto L35
            L29:
                r8 = r18;
                goto L31
            L25:
                r7 = r17;
                goto L27
            L21:
                r6 = r16;
                goto L23
            L17:
                r5 = r15;
                goto L19
            L13:
                r4 = r14;
                goto L15
            L9:
                r3 = r13;
                goto L11
            L5:
                r2 = r12;
                goto L7
            }

            public final int component1() {
                return this.height;
            }

            public final Integer component10() {
                return this.position;
            }

            public final int component2() {
                return this.width;
            }

            public final String component3() {
                return this.icon;
            }

            public final Integer component4() {
                return this.loop;
            }

            public final Integer component5() {
                return this.autoplay;
            }

            public final String component6() {
                return this.id;
            }

            public final String component7() {
                return this.backgroundIcon;
            }

            public final boolean component8() {
                return this.useBorderRadius;
            }

            public final Double component9() {
                return this.scale;
            }

            public final MemoryIcon copy(int r13, int r14, String r15, Integer r16, Integer r17, String r18, String r19, boolean r20, Double r21, Integer r22) {
                Intrinsics.checkNotNullParameter(r15, "icon");
                return new MemoryIcon(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, MemoryIcon.class) == true) goto L8;
                return false;
            L8:
                MemoryIcon r6 = (MemoryIcon) ZeusTransformUtils.preCheckCast(r5, MemoryIcon.class, "com.obric.memorydata.plugin");
                if (this.height == r6.height) goto L12;
                return false;
            L12:
                if (this.width == r6.width) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.loop, r6.loop) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.autoplay, r6.autoplay) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.id, r6.id) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.backgroundIcon, r6.backgroundIcon) == true) goto L30;
                return false;
            L30:
                if (this.useBorderRadius == r6.useBorderRadius) goto L33;
                return false;
            L33:
                if (Intrinsics.areEqual(this.scale, r6.scale) == true) goto L36;
                return false;
            L36:
                if (Intrinsics.areEqual(this.position, r6.position) == true) goto L38;
                return false;
            L38:
                return true;
            }

            public final Integer getAutoplay() {
                return this.autoplay;
            }

            public final String getBackgroundIcon() {
                return this.backgroundIcon;
            }

            public final int getHeight() {
                return this.height;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getId() {
                return this.id;
            }

            public final Integer getLoop() {
                return this.loop;
            }

            public final Integer getPosition() {
                return this.position;
            }

            public final Double getScale() {
                return this.scale;
            }

            public final boolean getUseBorderRadius() {
                return this.useBorderRadius;
            }

            public final int getWidth() {
                return this.width;
            }

            public int hashCode() {
                int r0 = ((((Integer.hashCode(this.height) * 31) + Integer.hashCode(this.width)) * 31) + this.icon.hashCode()) * 31;
                Integer r1 = this.loop;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Integer r5 = this.autoplay;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                String r8 = this.id;
                if (r8 != null) goto L13;
                int r9 = 0;
            L14:
                int r10 = (r7 + r9) * 31;
                String r11 = this.backgroundIcon;
                if (r11 != null) goto L17;
                int r12 = 0;
            L18:
                int r13 = (((r10 + r12) * 31) + Boolean.hashCode(this.useBorderRadius)) * 31;
                Double r14 = this.scale;
                if (r14 != null) goto L21;
                int r15 = 0;
            L22:
                int r16 = (r13 + r15) * 31;
                Integer r17 = this.position;
                if (r17 == null) goto L27;
                r2 = r17.hashCode();
            L27:
                return r16 + r2;
            L21:
                r15 = r14.hashCode();
                goto L22
            L17:
                r12 = r11.hashCode();
                goto L18
            L13:
                r9 = r8.hashCode();
                goto L14
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final void setAutoplay(Integer r1) {
                this.autoplay = r1;
            }

            public final void setBackgroundIcon(String r1) {
                this.backgroundIcon = r1;
            }

            public final void setHeight(int r1) {
                this.height = r1;
            }

            public final void setIcon(String r2) {
                Intrinsics.checkNotNullParameter(r2, "<set-?>");
                this.icon = r2;
            }

            public final void setId(String r1) {
                this.id = r1;
            }

            public final void setLoop(Integer r1) {
                this.loop = r1;
            }

            public final void setPosition(Integer r1) {
                this.position = r1;
            }

            public final void setScale(Double r1) {
                this.scale = r1;
            }

            public final void setUseBorderRadius(boolean r1) {
                this.useBorderRadius = r1;
            }

            public final void setWidth(int r1) {
                this.width = r1;
            }

            public String toString() {
                return "MemoryIcon(height=" + this.height + ", width=" + this.width + ", icon=" + this.icon + ", loop=" + this.loop + ", autoplay=" + this.autoplay + ", id=" + this.id + ", backgroundIcon=" + this.backgroundIcon + ", useBorderRadius=" + this.useBorderRadius + ", scale=" + this.scale + ", position=" + this.position + ')';
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIslandTextColor;", "", "light", "", "dark", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLight", "()Ljava/lang/String;", "getDark", "PRIMARY", "SECONDARY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final enum MemoryIslandTextColor extends Enum<MemoryIslandTextColor> {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ MemoryIslandTextColor[] $VALUES = null;
            public static final MemoryIslandTextColor PRIMARY = null;
            public static final MemoryIslandTextColor SECONDARY = null;
            private final String dark;
            private final String light;

            private static final /* synthetic */ MemoryIslandTextColor[] $values() {
                return new MemoryIslandTextColor[]{PRIMARY, SECONDARY};
            }

            static {
                PRIMARY = new MemoryIslandTextColor("PRIMARY", 0, "#E6000000", "#E6FFFFFF");
                SECONDARY = new MemoryIslandTextColor("SECONDARY", 1, "#73000000", "#80FFFFFF");
                MemoryIslandTextColor[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            }

            private MemoryIslandTextColor(String r1, int r2, String r3, String r4) {
                super(r1, r2);
                this.light = r3;
                this.dark = r4;
            }

            public static EnumEntries<MemoryIslandTextColor> getEntries() {
                return $ENTRIES;
            }

            public static MemoryIslandTextColor valueOf(String r2) {
                return (MemoryIslandTextColor) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryIslandTextColor.class, r2), MemoryIslandTextColor.class, "com.obric.memorydata.plugin");
            }

            public static MemoryIslandTextColor[] values() {
                return (MemoryIslandTextColor[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryIslandTextColor[].class, "com.obric.memorydata.plugin");
            }

            public final String getDark() {
                return this.dark;
            }

            public final String getLight() {
                return this.light;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryIslandVisualState;", "", "<init>", "(Ljava/lang/String;I)V", "IN_PROGRESS", "SUCCESS", RawObservationEntity.STATE_FAILED, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final enum MemoryIslandVisualState extends Enum<MemoryIslandVisualState> {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ MemoryIslandVisualState[] $VALUES = null;
            public static final MemoryIslandVisualState FAILED = null;
            public static final MemoryIslandVisualState IN_PROGRESS = null;
            public static final MemoryIslandVisualState SUCCESS = null;

            private static final /* synthetic */ MemoryIslandVisualState[] $values() {
                return new MemoryIslandVisualState[]{IN_PROGRESS, SUCCESS, FAILED};
            }

            static {
                IN_PROGRESS = new MemoryIslandVisualState("IN_PROGRESS", 0);
                SUCCESS = new MemoryIslandVisualState("SUCCESS", 1);
                FAILED = new MemoryIslandVisualState(RawObservationEntity.STATE_FAILED, 2);
                MemoryIslandVisualState[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            }

            private MemoryIslandVisualState(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumEntries<MemoryIslandVisualState> getEntries() {
                return $ENTRIES;
            }

            public static MemoryIslandVisualState valueOf(String r2) {
                return (MemoryIslandVisualState) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryIslandVisualState.class, r2), MemoryIslandVisualState.class, "com.obric.memorydata.plugin");
            }

            public static MemoryIslandVisualState[] values() {
                return (MemoryIslandVisualState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryIslandVisualState[].class, "com.obric.memorydata.plugin");
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$CompatibleIconButton;", "", "legacy", "Lcom/obric/livecard/api/entity/Button;", "intermediate", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$LegacyIconButtonPayload;", "latest", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Lcom/obric/livecard/api/entity/Button;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$LegacyIconButtonPayload;Lcom/obric/livecard/api/entity/ButtonV2;)V", "getLegacy", "()Lcom/obric/livecard/api/entity/Button;", "getIntermediate", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$LegacyIconButtonPayload;", "getLatest", "()Lcom/obric/livecard/api/entity/ButtonV2;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Button f10219a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final LegacyIconButtonPayload f10220b;
            private final ButtonV2 c;

            public a(Button r2, LegacyIconButtonPayload r3, ButtonV2 r4) {
                Intrinsics.checkNotNullParameter(r2, "legacy");
                Intrinsics.checkNotNullParameter(r3, "intermediate");
                Intrinsics.checkNotNullParameter(r4, "latest");
                this.f10219a = r2;
                this.f10220b = r3;
                this.c = r4;
            }

            public final Button a() {
                return this.f10219a;
            }

            public final LegacyIconButtonPayload b() {
                return this.f10220b;
            }

            public final ButtonV2 c() {
                return this.c;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10219a, r6.f10219a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10220b, r6.f10220b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f10219a.hashCode() * 31) + this.f10220b.hashCode()) * 31) + this.c.hashCode();
            }

            public String toString() {
                return "CompatibleIconButton(legacy=" + this.f10219a + ", intermediate=" + this.f10220b + ", latest=" + this.c + ')';
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JM\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$IslandContent;", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "title", "", Params.CONTENT, "calendars", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "clickListTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "clickForceAll", "", "<init>", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/obric/memorydata/memory/ui/list/MemoryTab;Z)V", "getEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getTitle", "()Ljava/lang/String;", "getContent", "getCalendars", "()Ljava/util/List;", "getClickListTab", "()Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "getClickForceAll", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final MemoryEntity f10221a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f10222b;
            private final String c;
            private final List<PendingMemoryCalendar> d;
            private final MemoryTab e;
            private final boolean f;

            public b(MemoryEntity r3, String r4, String r5, List<PendingMemoryCalendar> r6, MemoryTab r7, boolean r8) {
                List<PendingMemoryCalendar> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "entity");
                Intrinsics.checkNotNullParameter(r4, "title");
                Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r9, "calendars");
                this.f10221a = r3;
                this.f10222b = r4;
                this.c = r5;
                this.d = r9;
                this.e = r7;
                this.f = r8;
            }

            public /* synthetic */ b(MemoryEntity r8, String r9, String r10, List r11, MemoryTab r12, boolean r13, int r14, DefaultConstructorMarker r15) {
                List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
                if ((r14 & 8) == 0) goto L5;
                r16 = CollectionsKt.emptyList();
            L5:
                List r4 = r16;
                if ((r14 & 16) == 0) goto L8;
                r12 = null;
            L8:
                MemoryTab r5 = r12;
                if ((r14 & 32) == 0) goto L11;
                r13 = false;
            L11:
                this(r8, r9, r10, r4, r5, r13);
            }

            public static /* synthetic */ b a(b r7, MemoryEntity r8, String r9, String r10, List r11, MemoryTab r12, boolean r13, int r14, Object r15) {
                List<PendingMemoryCalendar> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
                if ((r14 & 1) == 0) goto L5;
                r8 = r7.f10221a;
            L5:
                MemoryEntity r1 = r8;
                if ((r14 & 2) == 0) goto L8;
                r9 = r7.f10222b;
            L8:
                String r2 = r9;
                if ((r14 & 4) == 0) goto L11;
                r10 = r7.c;
            L11:
                String r3 = r10;
                if ((r14 & 8) == 0) goto L14;
                r16 = r7.d;
            L14:
                List<PendingMemoryCalendar> r4 = r16;
                if ((r14 & 16) == 0) goto L17;
                r12 = r7.e;
            L17:
                MemoryTab r5 = r12;
                if ((r14 & 32) == 0) goto L21;
                r13 = r7.f;
            L21:
                return r7.a(r1, r2, r3, r4, r5, r13);
            }

            public final MemoryEntity a() {
                return this.f10221a;
            }

            public final b a(MemoryEntity r8, String r9, String r10, List<PendingMemoryCalendar> r11, MemoryTab r12, boolean r13) {
                List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r8, "entity");
                Intrinsics.checkNotNullParameter(r9, "title");
                Intrinsics.checkNotNullParameter(r10, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r4, "calendars");
                return new b(r8, r9, r10, r4, r12, r13);
            }

            public final String b() {
                return this.f10222b;
            }

            public final String c() {
                return this.c;
            }

            public final List<PendingMemoryCalendar> d() {
                return this.d;
            }

            public final MemoryTab e() {
                return this.e;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10221a, r6.f10221a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10222b, r6.f10222b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
                return false;
            L21:
                if (this.e == r6.e) goto L24;
                return false;
            L24:
                if (this.f == r6.f) goto L26;
                return false;
            L26:
                return true;
            }

            public final boolean f() {
                return this.f;
            }

            public int hashCode() {
                int r0 = ((((((this.f10221a.hashCode() * 31) + this.f10222b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
                MemoryTab r1 = this.e;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return ((r0 + r2) * 31) + Boolean.hashCode(this.f);
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "IslandContent(entity=" + this.f10221a + ", title=" + this.f10222b + ", content=" + this.c + ", calendars=" + this.d + ", clickListTab=" + this.e + ", clickForceAll=" + this.f + ')';
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0001HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$ResolvedExpandTemplate;", "", "type", "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryExpandTemplateType;", "templateData", Params.CONTENT, "Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$IslandContent;", "actionContents", "", "", "<init>", "(Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryExpandTemplateType;Ljava/lang/Object;Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$IslandContent;Ljava/util/Map;)V", "getType", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$MemoryExpandTemplateType;", "getTemplateData", "()Ljava/lang/Object;", "getContent", "()Lcom/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$IslandContent;", "getActionContents", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final MemoryExpandTemplateType f10223a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f10224b;
            private final b c;
            private final Map<String, b> d;

            public c(MemoryExpandTemplateType r3, Object r4, b r5, Map<String, b> r6) {
                Map<String, b> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "type");
                Intrinsics.checkNotNullParameter(r4, "templateData");
                Intrinsics.checkNotNullParameter(r7, "actionContents");
                this.f10223a = r3;
                this.f10224b = r4;
                this.c = r5;
                this.d = r7;
            }

            public final Object a() {
                return this.f10224b;
            }

            public final b b() {
                return this.c;
            }

            public final Map<String, b> c() {
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
                if (this.f10223a == r6.f10223a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10224b, r6.f10224b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final MemoryExpandTemplateType getType() {
                return this.f10223a;
            }

            public int hashCode() {
                int r0 = ((this.f10223a.hashCode() * 31) + this.f10224b.hashCode()) * 31;
                b r1 = this.c;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return ((r0 + r2) * 31) + this.d.hashCode();
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "ResolvedExpandTemplate(type=" + this.f10223a + ", templateData=" + this.f10224b + ", content=" + this.c + ", actionContents=" + this.d + ')';
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10225a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f10226b = null;
            public static final /* synthetic */ int[] c = null;

            static {
                int[] r0 = new int[MemoryTab.values().length];
                r0[MemoryTab.PROFILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L4:
                f10225a = r0;
                int[] r1 = new int[MemoryIslandVisualState.values().length];
                r1[MemoryIslandVisualState.IN_PROGRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
            L22:
                r1[MemoryIslandVisualState.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
            L30:
                r1[MemoryIslandVisualState.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
            L9:
                f10226b = r1;
                int[] r2 = new int[BatchMemoryIslandKind.values().length];
                r2[BatchMemoryIslandKind.EPISODIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
            L20:
                r2[BatchMemoryIslandKind.SEMANTIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
            L12:
                c = r2;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final ColorToken a(MemoryIslandTextColor r4) {
            return a(new ColorHex(r4.getLight(), r4.getDark()), new ColorHex(r4.getDark(), r4.getDark()));
        }

        public static final /* synthetic */ ColorToken a(Companion r0) {
            return r0.c();
        }

        private final Icon a(int r16, int r17, String r18) {
            return new Icon(r17, r16, ResourceUtils.INSTANCE.getAssetsFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "ic_memory_done.svg", "svg"), null, null, r18, null, false, null, null, null, 2008, null);
        }

        static /* synthetic */ IslandWidget a(Companion r0, Object r1, Boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = false;
        L6:
            return r0.a(r1, r2);
        }

        private final IslandWidget a(Object r2, Boolean r3) {
            if (ZeusTransformUtils.instanceOf(r2, MemoryExpandedTemplate.class) == false) goto L6;
            return ((MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r2, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin")).create(r3);
        L6:
            if (ZeusTransformUtils.instanceOf(r2, MemoryBatchExpandedTemplate.class) == false) goto L10;
            return ((MemoryBatchExpandedTemplate) ZeusTransformUtils.preCheckCast(r2, MemoryBatchExpandedTemplate.class, "com.obric.memorydata.plugin")).create(r3);
        L10:
            throw new IllegalStateException(("unsupported memory expand template: " + r2.getClass().getName()).toString());
        }

        private final com.obric.memorydata.memory.island.a a(List<com.obric.memorydata.memory.island.b> r8, BatchMemoryIslandKind r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            if (r10 != null) goto L5;
            r10 = CollectionsKt.emptyList();
        L5:
            com.obric.memorydata.memory.island.b r0 = (com.obric.memorydata.memory.island.b) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r10), com.obric.memorydata.memory.island.b.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L9;
            return null;
        L9:
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(a(r0.b()), CharSequence.class, "com.obric.memorydata.plugin");
            if (StringsKt.isBlank(r7) == false) goto L13;
            r7 = IslandSessionUtils.f10217a.a(r9);
        L13:
            return new com.obric.memorydata.memory.island.a(r9, (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), r10.size(), r0.b(), r0.c());
        }

        public static /* synthetic */ CompatibleCommonExpandedTemplate a(Companion r6, CompatibleText r7, List r8, Icon r9, CompatibleText r10, Icon r11, int r12, Object r13) {
            List<a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 2) == 0) goto L5;
            r14 = CollectionsKt.emptyList();
        L5:
            List<a> r2 = r14;
            if ((r12 & 4) == 0) goto L8;
            Icon r3 = null;
        L10:
            if ((r12 & 8) == 0) goto L12;
            CompatibleText r4 = null;
        L14:
            if ((r12 & 16) == 0) goto L16;
            Icon r5 = null;
        L18:
            return r6.a(r7, r2, r3, r4, r5);
        L16:
            r5 = r11;
            goto L18
        L12:
            r4 = r10;
            goto L14
        L8:
            r3 = r9;
            goto L10
        }

        public static final /* synthetic */ CompatibleText a(Companion r0, String r1, int r2, int r3, MemoryIslandTextColor r4) {
            return r0.a(r1, r2, r3, r4);
        }

        private final CompatibleText a(String r1, int r2, int r3, MemoryIslandTextColor r4) {
            return a(r1, r2, a(r3), a(r4));
        }

        public static /* synthetic */ MemoryBatchExpandedTemplate a(Companion r1, CompatibleText r2, Object r3, List r4, int r5, Object r6) {
            List<MemoryBatchMessage> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r7 = null;
        L12:
            return r1.a(r2, r3, r7);
        }

        public static /* synthetic */ MemoryCollapseTemplate a(Companion r1, CompatibleText r2, CompatibleText r3, Icon r4, Object r5, int r6, Object r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r5 = null;
        L15:
            return r1.a(r2, r3, r4, r5);
        }

        private final MemoryExpandedTemplate a(MemoryBatchExpandedTemplate r20, MemoryIslandVisualState r21) {
            Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            List<MemoryBatchMessage> r0 = r20.getMessageList();
            if (r0 == null) goto L5;
            MemoryBatchMessage r12 = (MemoryBatchMessage) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r0), MemoryBatchMessage.class, "com.obric.memorydata.plugin");
        L6:
            int r1 = d.f10226b[r21.ordinal()];
            if (r1 != 1) goto L9;
            CompatibleText r2 = r20.getContent();
            if (r2 != null) goto L31;
            String r3 = r10.getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_in_progress, TypedValues.Custom.S_STRING, "memory_island_memory_in_progress"));
            Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
            r2 = a(r3, 16, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY);
        L31:
            CompatibleText r4 = r2;
            List r5 = null;
            Object r6 = null;
            CompatibleText r7 = null;
            Icon r8 = null;
            int r9 = 30;
        L32:
            return a(this, r4, r5, r6, r7, r8, r9, null);
        L9:
            if (r1 != 2) goto L11;
            r5 = CollectionsKt.listOf(a(this, 40, 40, ResourceUtils.INSTANCE.getAssetsFile(r10, "ic_memory_success.svg", "svg"), null, c(), null, 40, null));
            if (r12 == null) goto L20;
            CompatibleText r11 = r12.getContent();
            if (r11 == null) goto L20;
        L23:
            r4 = r11;
            if (r12 == null) goto L26;
            r7 = r12.getTitle();
        L27:
            r6 = null;
            r8 = null;
            r9 = 20;
            goto L32
        L26:
            r7 = null;
        L20:
            r11 = r20.getContent();
            if (r11 != null) goto L23;
            String r13 = r10.getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));
            Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
            r11 = a(r13, 16, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY);
            goto L23
        L11:
            if (r1 != 3) goto L15;
            r5 = CollectionsKt.listOf(a(this, 40, 40, ResourceUtils.INSTANCE.getAssetsFile(r10, "ic_memory_failed.svg", "svg"), null, null, null, 56, null));
            String r14 = r10.getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_failed_retry, TypedValues.Custom.S_STRING, "memory_island_memory_failed_retry"));
            Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
            r4 = a(r14, 16, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY);
            r6 = null;
            r7 = null;
            r8 = null;
            r9 = 28;
            goto L32
        L15:
            throw new NoWhenBranchMatchedException();
        L5:
            r12 = null;
            goto L6
        }

        public static /* synthetic */ MemoryExpandedTemplate a(Companion r6, CompatibleText r7, List r8, Object r9, CompatibleText r10, Icon r11, int r12, Object r13) {
            List<a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 2) == 0) goto L5;
            r14 = CollectionsKt.emptyList();
        L5:
            List<a> r2 = r14;
            if ((r12 & 4) == 0) goto L8;
            Object r3 = null;
        L10:
            if ((r12 & 8) == 0) goto L12;
            CompatibleText r4 = null;
        L14:
            if ((r12 & 16) == 0) goto L16;
            Icon r5 = null;
        L18:
            return r6.a(r7, r2, r3, r4, r5);
        L16:
            r5 = r11;
            goto L18
        L12:
            r4 = r10;
            goto L14
        L8:
            r3 = r9;
            goto L10
        }

        private final MemoryIcon a(int r18, int r19, String r20, int r21, int r22, int r23) {
            String r11 = null;
            boolean r12 = false;
            return new MemoryIcon(r19, r18, ResourceUtils.INSTANCE.getAssetsFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "ap_island_memory.zip", "alpha-video"), Integer.valueOf(r22), Integer.valueOf(r21), r20, r11, r12, Double.valueOf(1.7d), Integer.valueOf(r23), 192, null);
        }

        private final MemoryIcon a(int r18, int r19, String r20, int r21, int r22, Integer r23) {
            return new MemoryIcon(r19, r18, ResourceUtils.INSTANCE.getAssetsFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "ap_island_memory.zip", "alpha-video"), Integer.valueOf(r22), Integer.valueOf(r21), r20, null, false, null, r23, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
        }

        static /* synthetic */ MemoryIcon a(Companion r7, int r8, int r9, String r10, int r11, int r12, Integer r13, int r14, Object r15) {
            if ((r14 & 32) == 0) goto L6;
            r13 = null;
        L6:
            return r7.a(r8, r9, r10, r11, r12, r13);
        }

        public static final /* synthetic */ MemoryIslandVisualState a(Companion r0, Object r1) {
            return r0.a(r1);
        }

        private final MemoryIslandVisualState a(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, MemoryBatchExpandedTemplate.class) == false) goto L14;
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(((MemoryBatchExpandedTemplate) ZeusTransformUtils.preCheckCast(r4, MemoryBatchExpandedTemplate.class, "com.obric.memorydata.plugin")).getMessageList(), Collection.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L7;
        L10:
            boolean r5 = true;
        L11:
            if (r5 == true) goto L14;
            return MemoryIslandVisualState.SUCCESS;
        L7:
            if (r3.isEmpty() == true) goto L10;
            r5 = false;
        L14:
            String r1 = null;
            if (ZeusTransformUtils.instanceOf(r4, MemoryExpandedTemplate.class) == false) goto L19;
            CompatibleText r6 = ((MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r4, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin")).getContent();
        L17:
            r1 = r6.getText();
        L24:
            if (Intrinsics.areEqual(r1, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_failed, TypedValues.Custom.S_STRING, "memory_island_memory_failed"))) == false) goto L27;
            return MemoryIslandVisualState.FAILED;
        L27:
            return MemoryIslandVisualState.IN_PROGRESS;
        L19:
            if (ZeusTransformUtils.instanceOf(r4, MemoryBatchExpandedTemplate.class) == false) goto L24;
            r6 = ((MemoryBatchExpandedTemplate) ZeusTransformUtils.preCheckCast(r4, MemoryBatchExpandedTemplate.class, "com.obric.memorydata.plugin")).getContent();
            if (r6 == null) goto L24;
            goto L17
        }

        public static /* synthetic */ a a(Companion r9, int r10, int r11, String r12, String r13, ColorToken r14, String r15, int r16, Object r17) {
            if ((r16 & 8) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r16 & 16) == 0) goto L9;
            ColorToken r7 = null;
        L11:
            if ((r16 & 32) == 0) goto L13;
            String r8 = r12;
        L15:
            return r9.a(r10, r11, r12, r6, r7, r8);
        L13:
            r8 = r15;
            goto L15
        L9:
            r7 = r14;
            goto L11
        L5:
            r6 = r13;
            goto L7
        }

        private final b a(com.obric.memorydata.memory.island.a r8, List<PendingMemoryCalendar> r9) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            if (r8.c() <= 1) goto L5;
            MemoryTab r10 = b(r8.a());
        L6:
            MemoryTab r5 = r10;
            MemoryEntity r1 = r8.d();
            String r2 = b(r8.a()).getText();
            String r3 = r8.b();
            if (r5 == null) goto L9;
            boolean r6 = true;
        L11:
            return new b(r1, r2, r3, r4, r5, r6);
        L9:
            r6 = false;
            goto L11
        L5:
            r10 = null;
            goto L6
        }

        public static final /* synthetic */ c a(Companion r6, Object r7, b r8, Map r9, MemoryIslandVisualState r10, boolean r11) {
            return r6.a(r7, r8, (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin"), r10, r11);
        }

        private final c a(Object r3, b r4, Map<String, b> r5, MemoryIslandVisualState r6, boolean r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, MemoryBatchExpandedTemplate.class) == false) goto L9;
            if (r7 == false) goto L7;
            MemoryExpandTemplateType r9 = IslandSessionUtils.a();
            if (r9 == null) goto L7;
        L12:
            if (r9 == MemoryExpandTemplateType.LEGACY) goto L14;
        L16:
            Object r2 = r3;
        L18:
            if (r9 != MemoryExpandTemplateType.LEGACY) goto L31;
            if (ZeusTransformUtils.instanceOf(r3, MemoryBatchExpandedTemplate.class) == false) goto L31;
            List<MemoryBatchMessage> r10 = ((MemoryBatchExpandedTemplate) ZeusTransformUtils.preCheckCast(r3, MemoryBatchExpandedTemplate.class, "com.obric.memorydata.plugin")).getMessageList();
            if (r10 == null) goto L31;
            MemoryBatchMessage r11 = (MemoryBatchMessage) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r10), MemoryBatchMessage.class, "com.obric.memorydata.plugin");
            if (r11 == null) goto L31;
            String r12 = r11.getId();
            if (r12 == null) goto L31;
            b r13 = (b) ZeusTransformUtils.preCheckCast(r8.get(r12), b.class, "com.obric.memorydata.plugin");
            if (r13 == null) goto L31;
            r4 = r13;
        L31:
            if (r9 == MemoryExpandTemplateType.BATCH) goto L35;
            r8 = MapsKt.emptyMap();
        L35:
            return new c(r9, r2, r4, r8);
        L14:
            if (ZeusTransformUtils.instanceOf(r3, MemoryBatchExpandedTemplate.class) == false) goto L16;
            r2 = a((MemoryBatchExpandedTemplate) ZeusTransformUtils.preCheckCast(r3, MemoryBatchExpandedTemplate.class, "com.obric.memorydata.plugin"), r6);
        L7:
            r9 = b();
            goto L12
        L9:
            if (ZeusTransformUtils.instanceOf(r3, MemoryExpandedTemplate.class) == false) goto L37;
            r9 = MemoryExpandTemplateType.LEGACY;
            goto L12
        L37:
            throw new IllegalStateException(("unsupported memory expand template: " + r3.getClass().getName()).toString());
        }

        private static final CharSequence a(com.obric.memorydata.memory.island.a r3) {
            Intrinsics.checkNotNullParameter(r3, "group");
            Companion r0 = IslandSessionUtils.f10217a;
            BatchMemoryIslandKind r1 = r3.a();
            int r2 = d.c[r1.ordinal()];
            if (r2 != 1) goto L5;
            MemoryTab r4 = MemoryTab.COLLECT;
        L11:
            return (CharSequence) ZeusTransformUtils.preCheckCast(r0.a(r3, r4.getText()), CharSequence.class, "com.obric.memorydata.plugin");
        L5:
            if (r2 != 2) goto L8;
            r4 = MemoryTab.PROFILE;
            goto L11
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public static /* synthetic */ Object a(Companion r1, long r2, Continuation r4, int r5, Object r6) {
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = 5000;
        L6:
            return r1.a(r2, r7);
        }

        private final String a(int r5) {
            StringCompanionObject r4 = StringCompanionObject.INSTANCE;
            String r6 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(r5))}, 1));
            Intrinsics.checkNotNullExpressionValue(r6, "format(...)");
            return r6;
        }

        private final String a(MemoryEntity r6) {
            String r2 = "";
            if (ZeusTransformUtils.instanceOf(r6, OrderFlightMemoryEntity.class) == false) goto L16;
            StringBuilder r5 = new StringBuilder();
            String r4 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber();
            if (r4 != null) goto L7;
            r4 = "";
        L7:
            StringBuilder r7 = r5.append(r4).append(' ');
            String r1 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace();
            if (r1 != null) goto L10;
            r1 = "";
        L10:
            StringBuilder r8 = r7.append(r1).append('-');
            String r9 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination();
            if (r9 == null) goto L111;
        L13:
            r2 = r9;
        L111:
            return r8.append(r2).toString();
        L16:
            if (ZeusTransformUtils.instanceOf(r6, OrderTrainMemoryEntity.class) == false) goto L27;
            StringBuilder r10 = new StringBuilder();
            String r11 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber();
            if (r11 != null) goto L20;
            r11 = "";
        L20:
            StringBuilder r12 = r10.append(r11).append(' ');
            String r3 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace();
            if (r3 != null) goto L23;
            r3 = "";
        L23:
            r8 = r12.append(r3).append('-');
            r9 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination();
            if (r9 != null) goto L13;
        L27:
            if (ZeusTransformUtils.instanceOf(r6, OrderHotelMemoryEntity.class) == false) goto L33;
            String r13 = ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelName();
            if (r13 != null) goto L112;
            return "";
        L112:
            return r13;
        L33:
            if (ZeusTransformUtils.instanceOf(r6, OrderMovieTicketMemoryEntity.class) == false) goto L38;
            r13 = ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieName();
            if (r13 != null) goto L112;
            return "";
        L38:
            if (ZeusTransformUtils.instanceOf(r6, OrderTicketMemoryEntity.class) == false) goto L43;
            r13 = ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getName();
            if (r13 != null) goto L112;
            return "";
        L43:
            if (ZeusTransformUtils.instanceOf(r6, OrderCommonMemoryEntity.class) == false) goto L48;
            r13 = ((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r6, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getOrderName();
            if (r13 != null) goto L112;
            return "";
        L48:
            if (ZeusTransformUtils.instanceOf(r6, CollectContentMemoryEntity.class) == false) goto L53;
            r13 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r6, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle();
            if (r13 != null) goto L112;
            return "";
        L53:
            if (ZeusTransformUtils.instanceOf(r6, CollectStoreMemoryEntity.class) == false) goto L58;
            r13 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r6, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getStoreName();
            if (r13 != null) goto L112;
            return "";
        L58:
            if (ZeusTransformUtils.instanceOf(r6, EventScheduleMemoryEntity.class) == false) goto L63;
            r13 = ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r6, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getScheduleNme();
            if (r13 != null) goto L112;
            return "";
        L63:
            if (ZeusTransformUtils.instanceOf(r6, EventTodoMemoryEntity.class) == false) goto L68;
            r13 = ((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r6, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin")).getContent();
            if (r13 != null) goto L112;
            return "";
        L68:
            if (ZeusTransformUtils.instanceOf(r6, InfoDocumentsMemoryEntity.class) == false) goto L76;
            StringBuilder r14 = new StringBuilder();
            String r0 = ((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getPerson();
            if (r0 != null) goto L72;
            r0 = "";
        L72:
            r8 = r14.append(r0);
            r9 = ((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getIdType();
            if (r9 != null) goto L13;
        L76:
            if (ZeusTransformUtils.instanceOf(r6, InfoAddressMemoryEntity.class) == false) goto L81;
            r13 = ((InfoAddressMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoAddressMemoryEntity.class, "com.obric.memorydata.plugin")).getAddressType();
            if (r13 != null) goto L112;
            return "";
        L81:
            if (ZeusTransformUtils.instanceOf(r6, InfoAnniversaryMemoryEntity.class) == false) goto L86;
            r13 = ((InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin")).getAnniversaryType();
            if (r13 != null) goto L112;
            return "";
        L86:
            if (ZeusTransformUtils.instanceOf(r6, InfoRelationshipMemoryEntity.class) == false) goto L94;
            StringBuilder r15 = new StringBuilder();
            String r16 = ((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getPersonName();
            if (r16 != null) goto L90;
            r16 = "";
        L90:
            r8 = r15.append(r16);
            r9 = ((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getRelationType();
            if (r9 != null) goto L13;
        L94:
            if (ZeusTransformUtils.instanceOf(r6, InfoCommonMemoryEntity.class) == false) goto L103;
            r13 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoValue();
            if (r13 != null) goto L112;
            r13 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r6, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getObservation();
            if (r13 != null) goto L112;
            r13 = r6.getDetail();
            if (r13 != null) goto L112;
            return "";
        L103:
            if (ZeusTransformUtils.instanceOf(r6, CommonTextMemoryEntity.class) == false) goto L109;
            r13 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r6, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle();
            if (r13 != null) goto L112;
            r13 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r6, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary();
            if (r13 != null) goto L112;
            return "";
        L109:
            r13 = r6.getDetail();
            if (r13 != null) goto L112;
            return "";
        }

        private final String a(BatchMemoryIslandKind r1) {
            int r0 = d.c[r1.ordinal()];
            if (r0 != 1) goto L5;
            MemoryTab r2 = MemoryTab.COLLECT;
        L11:
            return r2.getText();
        L5:
            if (r0 != 2) goto L8;
            r2 = MemoryTab.PROFILE;
            goto L11
        L8:
            throw new NoWhenBranchMatchedException();
        }

        private final String a(com.obric.memorydata.memory.island.a r2, String r3) {
            if (r2.c() <= 1) goto L5;
            String r1 = " 等" + r2.c() + 26465;
        L7:
            return r2.b() + r1 + '\n' + r3;
        L5:
            r1 = "";
            goto L7
        }

        private final String a(List<com.obric.memorydata.memory.island.a> r11) {
            return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$IslandSessionUtils$Companion$QV7CkY33WMU8Gp7iyJnU63FIns.INSTANCE, 30, null);
        }

        private final List<com.obric.memorydata.memory.island.a> a(com.obric.memorydata.memory.island.c r7) {
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.d(), Iterable.class, "com.obric.memorydata.plugin");
            Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L10;
            Object r2 = r9.next();
            BatchMemoryIslandKind r3 = ((com.obric.memorydata.memory.island.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.island.b.class, "com.obric.memorydata.plugin")).a();
            Object r4 = r0.get(r3);
            if (r4 != null) goto L8;
            r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r0.put(r3, r4);
        L8:
            ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r2);
            goto L4
        L10:
            return CollectionsKt.listOfNotNull(new com.obric.memorydata.memory.island.a[]{a((List) ZeusTransformUtils.preCheckCast(r0.get(BatchMemoryIslandKind.EPISODIC), List.class, "com.obric.memorydata.plugin"), BatchMemoryIslandKind.EPISODIC), a((List) ZeusTransformUtils.preCheckCast(r0.get(BatchMemoryIslandKind.SEMANTIC), List.class, "com.obric.memorydata.plugin"), BatchMemoryIslandKind.SEMANTIC)});
        }

        private static final Unit a(IslandSession r5) {
            RunLog.INSTANCE.debug("IslandSessionUtils", "点击了取消: " + r5.getExpandWidget());
            IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Exception -> L7
            if (r0 == null) goto L10;
            r0.destroySession(r5);     // Catch: Exception -> L7
        L10:
            return Unit.INSTANCE;
        L7:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error destroying session on cancel: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L10
        }

        private static final Unit a(b r8, IslandSession r9) {
            MemoryDetailActivity.a.a(MemoryDetailActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8.a(), MemoryEventTracker.SourceType.DYNAMIC_ISLAND.getValue(), false, 8, null);     // Catch: Exception -> L7
            IslandApi r10 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Exception -> L7
            if (r10 == null) goto L10;
            r10.destroySession(r9);     // Catch: Exception -> L7
        L10:
            return Unit.INSTANCE;
        L7:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error starting detail activity: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L10
        }

        private static final Unit a(Ref.BooleanRef r17, IslandSession r18, PendingMemoryCalendar r19) {
            if (r17.element == false) goto L5;
            r17.element = false;
            RunLog.INSTANCE.debug("IslandSessionUtils", "点击了添加日历: " + r18.getExpandWidget() + ", Thread: " + Thread.currentThread().getName());
            i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showCalendar$3$2$1(r19, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        L5:
            i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showCalendar$3$2$2(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return Unit.INSTANCE;
        }

        private final void a(IslandSession r7, IslandWidget r8, String r9, String r10, Integer r11) {
            if (r8 != null) goto L15;
            return;
        L15:
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
            JSONObject r12 = new JSONObject();     // Catch: Throwable -> L9
            r12.put(OaidModel.KEY_ID, r10);     // Catch: Throwable -> L9
            if (r11 == null) goto L7;
            r12.put("position", r11.intValue());     // Catch: Throwable -> L9
        L7:
            r7.sendAnyEvent(r8, r9, r12.toString());     // Catch: Throwable -> L9
            Object r13 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
            if (r14 == null) goto L17;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "send lottie event failed, eventId=" + r9 + ", iconId=" + r10 + ", error=" + r14.getMessage(), null, 4, null);
            return;
        L17:
            return;
        L9:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        private final void a(IslandSession r16, MemoryIslandVisualState r17) {
            int r0 = d.f10226b[r17.ordinal()];
            if (r0 != 1) goto L5;
            a(this, r16, r16.getCollapseWidget(), "play_lottie", "memory_video_collapse", null, 8, null);
            a(this, r16, r16.getExpandWidget(), "play_lottie", "memory_video_expand", null, 8, null);
            return;
        L5:
            if (r0 != 2) goto L7;
            a(r16, r16.getCollapseWidget(), "pause_lottie", "memory_video_collapse", Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            return;
        L7:
            if (r0 != 3) goto L10;
            a(r16, r16.getCollapseWidget(), "pause_lottie", "memory_video_collapse", Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            a(r16, r16.getExpandWidget(), "pause_lottie", "memory_video_expand", Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }

        private final void a(IslandWidget r4, Map<String, b> r5) {
            Iterator r3 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            final String r1 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
            final b r7 = (b) ZeusTransformUtils.preCheckCast(r6.getValue(), b.class, "com.obric.memorydata.plugin");
            r4.addOnViewClickCallback(r1, new $$Lambda$IslandSessionUtils$Companion$fQ6xkx0ZRi0rDARAp3Q_uOx62TY(r7, r1));
            goto L4
        }

        private final void a(com.obric.memorydata.memory.island.c r22, boolean r23) {
            List<com.obric.memorydata.memory.island.a> r8 = a(r22);
            com.obric.memorydata.memory.island.a r0 = (com.obric.memorydata.memory.island.a) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r8), com.obric.memorydata.memory.island.a.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            ListIterator<com.obric.memorydata.memory.island.a> r1 = r8.listIterator(r8.size());
        L6:
            MemoryTab r4 = null;
            if (r1.hasPrevious() == false) goto L14;
            com.obric.memorydata.memory.island.a r2 = r1.previous();
            if (((com.obric.memorydata.memory.island.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.island.a.class, "com.obric.memorydata.plugin")).c() <= 1) goto L11;
            boolean r6 = true;
        L12:
            if (r6 == false) goto L6;
        L15:
            com.obric.memorydata.memory.island.a r3 = (com.obric.memorydata.memory.island.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.island.a.class, "com.obric.memorydata.plugin");
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L17:
            if (r7.hasNext() == false) goto L20;
            com.obric.memorydata.memory.island.a r9 = (com.obric.memorydata.memory.island.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.memory.island.a.class, "com.obric.memorydata.plugin");
            Pair r10 = TuplesKt.to(IslandSessionUtils.f10217a.b(r9, r22.a()), IslandSessionUtils.f10217a.a(r9, r22.e()));
            r11.put(r10.getFirst(), r10.getSecond());
            goto L17
        L20:
            if (r3 == null) goto L25;
            MemoryEntity r12 = r3.d();
            if (r12 == null) goto L25;
            MemoryEntity r14 = r12;
        L26:
            String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));
            Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
            String r16 = a(r8);
            List<PendingMemoryCalendar> r17 = r22.e();
            if (r3 == null) goto L31;
            BatchMemoryIslandKind r15 = r3.a();
            if (r15 == null) goto L31;
            r4 = b(r15);
        L31:
            MemoryTab r18 = r4;
            if (r3 == null) goto L34;
            boolean r19 = true;
        L35:
            b r110 = new b(r14, r13, r16, r17, r18, r19);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "onBatchMemorySuccess id=" + r22.a() + ", content=" + r110.c(), false, 4, null);
            String r111 = r22.a();
            String r20 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));
            Intrinsics.checkNotNullExpressionValue(r20, "getString(...)");
            MemoryCollapseTemplate r21 = a(this, a(r20, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, null, 14, null);
            String r24 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));
            Intrinsics.checkNotNullExpressionValue(r24, "getString(...)");
            CompatibleText r25 = a(r24, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY);
            Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r28 = r26.iterator();
        L37:
            if (r28.hasNext() == false) goto L39;
            r27.add(IslandSessionUtils.f10217a.c((com.obric.memorydata.memory.island.a) ZeusTransformUtils.preCheckCast(r28.next(), com.obric.memorydata.memory.island.a.class, "com.obric.memorydata.plugin"), r22.a()));
            goto L37
        L39:
            a(this, r111, r21, a(this, r25, null, (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin"), 2, null), r23, true, r110, r11, null, false, 384, null);
            return;
        L34:
            r19 = false;
        L25:
            r14 = r0.d();
            goto L26
        L11:
            r6 = false;
            goto L12
        L14:
            r2 = null;
            goto L15
        }

        private final void a(MemoryCollapseTemplate r12, Object r13, MemoryIslandVisualState r14) {
            int r15 = d.f10226b[r14.ordinal()];
            if (r15 != 1) goto L5;
            r12.setStartIcon(a(this, 40, 40, "memory_video_collapse", 1, 1, null, 32, null));
            Object r16 = b(40, 40, "memory_video_expand");
        L13:
            a(r13, r16);
            return;
        L5:
            if (r15 != 2) goto L7;
            r12.setStartIcon(a(40, 40, "memory_video_collapse", 0, 0, Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)));
            r16 = a(20, 20, "memory_video_expand");
            goto L13
        L7:
            if (r15 != 3) goto L10;
            r12.setStartIcon(a(40, 40, "memory_video_collapse", 0, 0, Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)));
            r16 = a(40, 40, "memory_video_expand", 0, 0, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }

        private final void a(b r17) {
            MemoryTab r0 = r17.e();
            if (r0 != null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "openIslandContent detail, entityId=" + r17.a().getId(), false, 4, null);
            MemoryDetailActivity.a.a(MemoryDetailActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r17.a(), MemoryEventTracker.SourceType.DYNAMIC_ISLAND.getValue(), false, 8, null);
            return;
        L6:
            boolean r3 = true;
            if (d.f10225a[r0.ordinal()] != 1) goto L9;
            MemoryContainerTab r2 = MemoryContainerTab.PERSONAL_MEMORY;
        L10:
            MemoryContainerTab r9 = r2;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "openIslandContent list, tab=" + r0 + ", forceAll=" + r17.f() + ", entityId=" + r17.a().getId(), false, 4, null);
            MemoryListActivity.a r4 = MemoryListActivity.Companion;
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            AppEntity r6 = (AppEntity) ZeusTransformUtils.preCheckCast(r17.a(), AppEntity.class, "com.obric.memorydata.plugin");
            String r7 = MemoryEventTracker.SourceType.DYNAMIC_ISLAND.getValue();
            if (r17.f() == true) goto L13;
        L15:
            r3 = false;
        L16:
            boolean r10 = r3;
            if (r17.f() == true) goto L19;
        L21:
            String r1 = null;
        L22:
            MemoryListActivity.a.a(r4, r5, r6, r7, null, r9, r10, r1, 8, null);
            return;
        L19:
            if (r0 != MemoryTab.PROFILE) goto L21;
            r1 = PersonalTag.f11118a.a();
            goto L22
        L13:
            if (r0 != MemoryTab.COLLECT) goto L15;
        L9:
            r2 = MemoryContainerTab.GLOBAL_MEMORY;
            goto L10
        }

        private final void a(b r7, String r8) {
            i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$handleIslandContentClick$1(r8, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }

        static /* synthetic */ void a(Companion r6, IslandSession r7, IslandWidget r8, String r9, String r10, Integer r11, int r12, Object r13) {
            if ((r12 & 8) == 0) goto L5;
            r11 = null;
        L5:
            r6.a(r7, r8, r9, r10, r11);
        }

        public static final /* synthetic */ void a(Companion r0, IslandSession r1, MemoryIslandVisualState r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(Companion r2, IslandWidget r3, Map r4) {
            r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ void a(Companion r0, MemoryCollapseTemplate r1, Object r2, MemoryIslandVisualState r3) {
            r0.a(r1, r2, r3);
        }

        public static final /* synthetic */ void a(Companion r0, b r1) {
            r0.a(r1);
        }

        public static /* synthetic */ void a(Companion r7, String r8, int r9, MemoryEntity r10, MemoryEntity r11, boolean r12, List r13, int r14, Object r15) {
            List<PendingMemoryCalendar> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            if ((r14 & 16) == 0) goto L5;
            r12 = true;
        L5:
            boolean r5 = r12;
            if ((r14 & 32) == 0) goto L8;
            r16 = CollectionsKt.emptyList();
        L8:
            r7.a(r8, r9, r10, r11, r5, r16);
        }

        static /* synthetic */ void a(Companion r6, String r7, MemoryEntity r8, MemoryEntity r9, List r10, boolean r11, int r12, Object r13) {
            List<PendingMemoryCalendar> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 4) == 0) goto L5;
            r9 = null;
        L5:
            r6.a(r7, r8, r9, r4, r11);
        }

        public static /* synthetic */ void a(Companion r14, String r15, MemoryCollapseTemplate r16, Object r17, boolean r18, boolean r19, b r20, Map r21, Long r22, boolean r23, int r24, Object r25) {
            Map<String, b> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
            if ((r24 & 16) == 0) goto L5;
            boolean r9 = false;
        L7:
            if ((r24 & 32) == 0) goto L9;
            b r10 = null;
        L11:
            if ((r24 & 64) == 0) goto L13;
            r1 = MapsKt.emptyMap();
        L13:
            Map<String, b> r11 = r1;
            if ((r24 & 128) == 0) goto L16;
            Long r12 = null;
        L18:
            if ((r24 & 256) == 0) goto L20;
            boolean r13 = false;
        L21:
            r14.a(r15, r16, r17, r18, r9, r10, r11, r12, r13);
            return;
        L20:
            r13 = r23;
            goto L21
        L16:
            r12 = r22;
            goto L18
        L9:
            r10 = r20;
            goto L11
        L5:
            r9 = r19;
            goto L7
        }

        private final void a(Object r7, Object r8) {
            if (ZeusTransformUtils.instanceOf(r7, MemoryExpandedTemplate.class) == false) goto L6;
            ((MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin")).setIcon(r8);
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, MemoryBatchExpandedTemplate.class) == false) goto L8;
            ((MemoryBatchExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, MemoryBatchExpandedTemplate.class, "com.obric.memorydata.plugin")).setIcon(r8);
            return;
        L8:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "skip memory expand icon for unsupported template: " + r7.getClass().getName(), null, 4, null);
        }

        private final void a(String r23, MemoryEntity r24, MemoryEntity r25, List<PendingMemoryCalendar> r26, boolean r27) {
            List<PendingMemoryCalendar> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "onPassiveMemorySuccess " + r23, false, 4, null);     // Catch: Exception -> L14
            b r8 = b(r24, r25, r6);     // Catch: Exception -> L14
            RunLog r7 = RunLog.INSTANCE;     // Catch: Exception -> L14
            StringBuilder r9 = new StringBuilder().append("title: ");     // Catch: Exception -> L14
            String r10 = null;
            if (r8 == null) goto L6;
            String r11 = r8.b();     // Catch: Exception -> L14
        L7:
            StringBuilder r12 = r9.append(r11).append(", content: ");     // Catch: Exception -> L14
            if (r8 == null) goto L10;
            r10 = r8.c();     // Catch: Exception -> L14
        L10:
            r7.debug("IslandSessionUtils", r12.append(r10).toString());     // Catch: Exception -> L14
            if (r8 == null) goto L19;
            Companion r13 = IslandSessionUtils.f10217a;     // Catch: Exception -> L14
            Companion r15 = IslandSessionUtils.f10217a;     // Catch: Exception -> L14
            Companion r14 = IslandSessionUtils.f10217a;     // Catch: Exception -> L14
            String r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));     // Catch: Exception -> L14
            Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");     // Catch: Exception -> L14
            MemoryCollapseTemplate r17 = a(r15, r14.a(r16, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, null, 14, null);     // Catch: Exception -> L14
            Companion r18 = IslandSessionUtils.f10217a;     // Catch: Exception -> L14
            Companion r19 = IslandSessionUtils.f10217a;     // Catch: Exception -> L14
            String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));     // Catch: Exception -> L14
            Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");     // Catch: Exception -> L14
            a(r13, r23, r17, a(r18, r19.a(r2, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, CollectionsKt.listOf(new MemoryBatchMessage(r23, IslandSessionUtils.f10217a.a(r8.c(), 16, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), IslandSessionUtils.f10217a.a(r8.b(), 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_3, TypedValues.Custom.S_COLOR, "oui_on_accent_text_3"), MemoryIslandTextColor.SECONDARY), null, 8, null)), 2, null), r27, true, r8, MapsKt.mapOf(TuplesKt.to(r23, r8)), null, false, 384, null);     // Catch: Exception -> L14
            return;
        L19:
            return;
        L6:
            r11 = null;
        L14:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in onPassiveMemorySuccess: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final void a(String r17, boolean r18) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "onPassiveMemoryBegin " + r17, false, 4, null);     // Catch: Exception -> L5
            String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_in_progress, TypedValues.Custom.S_STRING, "memory_island_memory_in_progress"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");     // Catch: Exception -> L5
            a(this, r17, a(this, a(r11, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, null, 14, null), a(this, a(r11, 18, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, 6, null), r18, false, null, null, null, false, 464, null);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in onPassiveMemoryBegin: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final Icon b(int r16, int r17, String r18) {
            return new Icon(r17, r16, ResourceUtils.INSTANCE.getAssetsFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "ic_doubao_memory.svg", "svg"), null, null, r18, null, false, null, null, null, 2008, null);
        }

        private final MemoryExpandTemplateType b() {
            if (b("memory_batch_expand_template") == false) goto L6;
            return MemoryExpandTemplateType.BATCH;
        L6:
            return MemoryExpandTemplateType.LEGACY;
        }

        private final b b(MemoryEntity r10, MemoryEntity r11, List<PendingMemoryCalendar> r12) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        L60:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error transforming entity to content: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return null;
        L4:
            if (ZeusTransformUtils.instanceOf(r10, OrderFlightMemoryEntity.class) == false) goto L7;
            b r13 = new b(r10, MemoryTab.COLLECT.getText(), ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber() + ' ' + ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace() + '-' + ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination(), r4, null, false, 48, null);     // Catch: Exception -> L60
        L64:
            return r13;
        L7:
            if (ZeusTransformUtils.instanceOf(r10, OrderTrainMemoryEntity.class) == false) goto L10;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber() + ' ' + ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace() + '-' + ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L10:
            if (ZeusTransformUtils.instanceOf(r10, OrderHotelMemoryEntity.class) == false) goto L14;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelName(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L14:
            if (ZeusTransformUtils.instanceOf(r10, OrderMovieTicketMemoryEntity.class) == false) goto L17;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieName(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L17:
            if (ZeusTransformUtils.instanceOf(r10, OrderTicketMemoryEntity.class) == false) goto L20;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getName(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L20:
            if (ZeusTransformUtils.instanceOf(r10, OrderCommonMemoryEntity.class) == false) goto L23;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r10, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getOrderName(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L23:
            if (ZeusTransformUtils.instanceOf(r10, CollectContentMemoryEntity.class) == false) goto L26;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r10, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L26:
            if (ZeusTransformUtils.instanceOf(r10, CollectStoreMemoryEntity.class) == false) goto L29;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r10, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getStoreName(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L29:
            if (ZeusTransformUtils.instanceOf(r10, EventScheduleMemoryEntity.class) == false) goto L32;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r10, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getScheduleNme(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L32:
            if (ZeusTransformUtils.instanceOf(r10, EventTodoMemoryEntity.class) == false) goto L35;
            r13 = new b(r10, MemoryTab.COLLECT.getText(), ((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r10, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin")).getContent(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L35:
            if (ZeusTransformUtils.instanceOf(r10, InfoDocumentsMemoryEntity.class) == false) goto L41;
            String r2 = MemoryTab.PROFILE.getText();     // Catch: Exception -> L60
            StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L60
            String r1 = ((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r10, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getPerson();     // Catch: Exception -> L60
            if (r1 != null) goto L39;
            r1 = "";
        L39:
            r13 = new b(r10, r2, r0.append(r1).append(((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r10, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getIdType()).toString(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L41:
            if (ZeusTransformUtils.instanceOf(r10, InfoAddressMemoryEntity.class) == false) goto L44;
            r13 = new b(r10, MemoryTab.PROFILE.getText(), ((InfoAddressMemoryEntity) ZeusTransformUtils.preCheckCast(r10, InfoAddressMemoryEntity.class, "com.obric.memorydata.plugin")).getAddressType(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L44:
            if (ZeusTransformUtils.instanceOf(r10, InfoAnniversaryMemoryEntity.class) == false) goto L47;
            r13 = new b(r10, MemoryTab.PROFILE.getText(), ((InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r10, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin")).getAnniversaryType(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L47:
            if (ZeusTransformUtils.instanceOf(r10, InfoRelationshipMemoryEntity.class) == false) goto L50;
            r13 = new b(r10, MemoryTab.PROFILE.getText(), ((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r10, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getPersonName() + ((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r10, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getRelationType(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L50:
            if (ZeusTransformUtils.instanceOf(r10, InfoCommonMemoryEntity.class) == false) goto L53;
            r13 = new b(r10, MemoryTab.PROFILE.getText(), ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r10, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoValue(), r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L53:
            if (ZeusTransformUtils.instanceOf(r10, CommonTextMemoryEntity.class) == false) goto L58;
            String r3 = MemoryTab.COLLECT.getText();     // Catch: Exception -> L60
            String r5 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r10, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle();     // Catch: Exception -> L60
            if (r5 != null) goto L57;
            r5 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r10, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary();     // Catch: Exception -> L60
        L57:
            r13 = new b(r10, r3, r5, r4, null, false, 48, null);     // Catch: Exception -> L60
            goto L64
        L58:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "memoryEntity is not of any MemoryEntity!", null, 4, null);     // Catch: Exception -> L60
            return null;
        }

        private final MemoryTab b(BatchMemoryIslandKind r1) {
            int r0 = d.c[r1.ordinal()];
            if (r0 == 1) goto L10;
            if (r0 != 2) goto L8;
            return MemoryTab.PROFILE;
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return MemoryTab.COLLECT;
        }

        private final String b(com.obric.memorydata.memory.island.a r2, String r3) {
            StringBuilder r1 = new StringBuilder().append("memory_batch_").append(r3).append('_');
            String r4 = r2.a().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
            return r1.append(r4).toString();
        }

        private static final Unit b(b r3, String r4) {
            IslandSessionUtils.f10217a.a(r3, "batchAction:" + r4);
            return Unit.INSTANCE;
        }

        private final boolean b(String r10) {
            Bundle r1 = new Bundle();
            r1.putString(ObricMemoryConstants.KEY_PACKAGE_NAME, "com.obric.island_applet");
            r1.putString("appId", r10);
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L29
            Companion r9 = (Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            ContentProviderClient r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().acquireUnstableContentProviderClient("com.obric.appletapp.SystemAppletProvider");     // Catch: Throwable -> L29
            String r4 = null;
            if (r11 == null) goto L14;
            AutoCloseable r12 = (AutoCloseable) ZeusTransformUtils.preCheckCast(r11, AutoCloseable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            Bundle r2 = ((ContentProviderClient) ZeusTransformUtils.preCheckCast(r12, ContentProviderClient.class, "com.obric.memorydata.plugin")).call("getAIPackageInfo", null, r1);     // Catch: Throwable -> L9
            AutoCloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L29
        L15:
            if (r2 == null) goto L17;
            r4 = r2.getString("result");     // Catch: Throwable -> L29
        L17:
            CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            boolean r5 = true;
            if (r13 != null) goto L20;
        L23:
            boolean r14 = true;
        L24:
            if (r14 == false) goto L27;
            r5 = false;
        L27:
            Object r15 = Result.m1421constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L29
        L31:
            Throwable r6 = Result.m1424exceptionOrNullimpl(r15);
            if (r6 == null) goto L35;
            RunLog.INSTANCE.warn("IslandSessionUtils", "query island template support failed, appId=" + r10, r6);
        L35:
            if (Result.m1427isFailureimpl(r15) == false) goto L37;
            r15 = false;
        L37:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "island template supported=" + ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + ", appId=" + r10, false, 4, null);
            return ((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L20:
            if (StringsKt.isBlank(r13) == true) goto L23;
            r14 = false;
            goto L24
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            AutoCloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L29
            throw th;     // Catch: Throwable -> L29
        L14:
            r2 = null;
        L29:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L31
        }

        private final ColorToken c() {
            return a(MemoryIslandTextColor.PRIMARY);
        }

        private final MemoryBatchMessage c(com.obric.memorydata.memory.island.a r10, String r11) {
            String r12 = b(r10, r11);
            CompatibleText r1 = a(r10.b(), 16, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY);
            CompatibleText r2 = a(b(r10.a()).getText(), 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_3, TypedValues.Custom.S_COLOR, "oui_on_accent_text_3"), MemoryIslandTextColor.SECONDARY);
            if (r10.c() <= 1) goto L5;
            CompatibleText r9 = a(String.valueOf(r10.c()), 16, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.SECONDARY);
        L7:
            return new MemoryBatchMessage(r12, r1, r2, r9);
        L5:
            r9 = null;
            goto L7
        }

        private final void c(String r17) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "onPassiveMemoryFailed " + r17, false, 4, null);     // Catch: Exception -> L5
            String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_failed, TypedValues.Custom.S_STRING, "memory_island_memory_failed"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Exception -> L5
            MemoryCollapseTemplate r7 = a(this, a(r1, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, null, 14, null);     // Catch: Exception -> L5
            String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_failed, TypedValues.Custom.S_STRING, "memory_island_memory_failed"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");     // Catch: Exception -> L5
            a(this, r17, r7, a(this, a(r2, 18, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, 6, null), false, true, null, null, null, false, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in onPassiveMemoryFailed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: lambda$-QV7CkY33WMU8Gp7iyJnU63FIns, reason: not valid java name */
        public static /* synthetic */ CharSequence m719lambda$QV7CkY33WMU8Gp7iyJnU63FIns(com.obric.memorydata.memory.island.a r0) {
            return a(r0);
        }

        public static /* synthetic */ Unit lambda$Ktt4hqX2M5D6A74ZmAKbUqRcHnc(IslandSession r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$QTT2D-gOWIwcXpLhP3CT9BF79aA, reason: not valid java name */
        public static /* synthetic */ Unit m720lambda$QTT2DgOWIwcXpLhP3CT9BF79aA(Ref.BooleanRef r0, IslandSession r1, PendingMemoryCalendar r2) {
            return a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$SM-6QrR5vw4GKtPM_vnD25MOJHU, reason: not valid java name */
        public static /* synthetic */ Unit m721lambda$SM6QrR5vw4GKtPM_vnD25MOJHU(b r0, IslandSession r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ Unit lambda$fQ6xkx0ZRi0rDARAp3Q_uOx62TY(b r0, String r1) {
            return b(r0, r1);
        }

        public final ColorToken a(ColorHex r1, ColorHex r2) {
            if (r1 != null) goto L7;
            if (r2 != null) goto L7;
            return null;
        L7:
            return new ColorToken(r1, r2);
        }

        public final CompatibleCommonExpandedTemplate a(CompatibleText r12, List<a> r13, Icon r14, CompatibleText r15, Icon r16) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r0, "buttons");
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r4 = r2.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r3.add(((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin")).a());
            goto L4
        L6:
            List r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            r7.add(((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).b());
            goto L8
        L10:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r1.iterator();
        L12:
            if (r11.hasNext() == false) goto L15;
            r10.add(((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.memorydata.plugin")).c());
            goto L12
        L15:
            return new CompatibleCommonExpandedTemplate(r5, r12, r14, r15, r16, r9, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"));
        }

        public final CompatibleText a(String r12, int r13, String r14, ColorToken r15) {
            Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r14, "legacyColor");
            return new CompatibleText(r12, r13, r14, null, null, null, null, r15, 120, null);
        }

        public final MemoryBatchExpandedTemplate a(CompatibleText r2, Object r3, List<MemoryBatchMessage> r4) {
            return new MemoryBatchExpandedTemplate(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
        }

        public final MemoryCollapseTemplate a(CompatibleText r1, CompatibleText r2, Icon r3, Object r4) {
            return new MemoryCollapseTemplate(r3, r1, r4, r2);
        }

        public final MemoryExpandedTemplate a(CompatibleText r12, List<a> r13, Object r14, CompatibleText r15, Icon r16) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r0, "buttons");
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r4 = r2.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r3.add(((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin")).a());
            goto L4
        L6:
            List r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            r7.add(((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).b());
            goto L8
        L10:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r1.iterator();
        L12:
            if (r11.hasNext() == false) goto L15;
            r10.add(((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.memorydata.plugin")).c());
            goto L12
        L15:
            return new MemoryExpandedTemplate(r5, r12, r14, r15, r16, r9, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final a a(int r21, int r22, String r23, String r24, ColorToken r25, String r26) {
            Intrinsics.checkNotNullParameter(r23, "icon");
            Intrinsics.checkNotNullParameter(r26, "latestIcon");
            Boolean r6 = null;
            String r8 = null;
            Button r15 = new Button(r21, r22, r23, r24, r6, null, r8, null, null, 496, null);
            Object[] r7 = 0 == true ? 1 : 0;
            LegacyIconButtonPayload r12 = new LegacyIconButtonPayload(r23, Integer.valueOf(r21), Integer.valueOf(r22), r24, r6, r7, r8, r25, 112, null);
            Text r3 = null;
            Object[] r9 = 0 == true ? 1 : 0;
            Object[] r11 = 0 == true ? 1 : 0;
            return new a(r15, r12, new ButtonV2(r26, r3, Integer.valueOf(r21), Integer.valueOf(r22), r24, r9, r8, null, r25, r11, null, 1762, null));
        }

        public final Object a(long r24, Continuation<? super Unit> r26) {
            Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, IslandSessionUtils$Companion$autoDismiss$1.class) == false) goto L7;
            IslandSessionUtils$Companion$autoDismiss$1 r2 = (IslandSessionUtils$Companion$autoDismiss$1) ZeusTransformUtils.preCheckCast(r0, IslandSessionUtils$Companion$autoDismiss$1.class, "com.obric.memorydata.plugin");
            if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
            r2.label -= Integer.MIN_VALUE;
        L8:
            Object r1 = r2.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r2.label;
            if (r4 == 0) goto L24;
            if (r4 == 1) goto L21;
            if (r4 == 2) goto L18;
            if (r4 != 3) goto L14;
            Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r2.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r1);     // Catch: Exception -> L50
            throw r5;     // Catch: Exception -> L50
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            Unit r6 = (Unit) ZeusTransformUtils.preCheckCast(r2.L$0, Unit.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r1);     // Catch: Exception -> L50
        L53:
            return Unit.INSTANCE;
        L21:
            long r8 = r2.J$0;
            CoroutineContext.Element r7 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r2.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r10 = (o) ZeusTransformUtils.preCheckCast(r2.L$0, o.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r1);     // Catch: Exception -> L50
        L23:
            long r12 = r8;
            IslandSession r16 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(IslandSessionUtils.h()), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
            if (r16 == null) goto L40;
            Long r9 = IslandSessionUtils.g();     // Catch: Throwable -> L44
            if (r9 == null) goto L34;
            long r14 = Math.min(r12, RangesKt.coerceAtLeast(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue() - SystemClock.elapsedRealtime(), 0));     // Catch: Throwable -> L44
        L35:
            bx r11 = IslandSessionUtils.j();     // Catch: Throwable -> L44
            if (r11 == null) goto L38;
            bx.a.a(r11, null, 1, null);     // Catch: Throwable -> L44
        L38:
            Companion r13 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L44
            IslandSessionUtils.a(i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$autoDismiss$2$1$1(r12, r14, r16, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));     // Catch: Throwable -> L44
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L44
        L41:
            r2.L$0 = r15;     // Catch: Exception -> L50
            r2.L$1 = null;     // Catch: Exception -> L50
            r2.label = 2;     // Catch: Exception -> L50
            if (r10.b(r7, r2) != r3) goto L53;
            return r3;
        L34:
            r14 = r12;
            goto L35
        L40:
            r15 = null;
        L44:
            th = move-exception;
            r2.L$0 = th;     // Catch: Exception -> L50
            r2.L$1 = null;     // Catch: Exception -> L50
            r2.label = 3;     // Catch: Exception -> L50
            if (r10.b(r7, r2) != r3) goto L49;
            return r3;
        L49:
            throw th;     // Catch: Exception -> L50
        L24:
            ResultKt.throwOnFailure(r1);
            r10 = IslandSessionUtils.c();     // Catch: Exception -> L50
            r7 = r2.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L50
            r2.L$0 = r10;     // Catch: Exception -> L50
            r2.L$1 = r7;     // Catch: Exception -> L50
            r8 = r24;
            r2.J$0 = r8;     // Catch: Exception -> L50
            r2.label = 1;     // Catch: Exception -> L50
            if (r10.a(r7, r2) != r3) goto L23;
            return r3;
        L50:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in autoDismiss: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r2 = new IslandSessionUtils$Companion$autoDismiss$1(this, r0);
            goto L8
        }

        public final Object a(final b r45, Continuation<? super Unit> r46) {
            Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r46, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, IslandSessionUtils$Companion$showCalendar$2.class) == false) goto L7;
            IslandSessionUtils$Companion$showCalendar$2 r5 = (IslandSessionUtils$Companion$showCalendar$2) ZeusTransformUtils.preCheckCast(r3, IslandSessionUtils$Companion$showCalendar$2.class, "com.obric.memorydata.plugin");
            if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
            r5.label -= Integer.MIN_VALUE;
        L8:
            Object r4 = r5.result;
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r5.label;
            if (r6 == 0) goto L30;
            if (r6 == 1) goto L27;
            if (r6 == 2) goto L22;
            if (r6 == 3) goto L19;
            if (r6 != 4) goto L15;
            th = (Throwable) ZeusTransformUtils.preCheckCast(r5.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r4);     // Catch: Exception -> L76
        L75:
            throw th;     // Catch: Exception -> L76
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(r5.L$0, Unit.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r4);     // Catch: Exception -> L76
        L79:
            return Unit.INSTANCE;
        L22:
            CoroutineContext.Element r1 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r5.L$2, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r2 = (o) ZeusTransformUtils.preCheckCast(r5.L$1, o.class, "com.obric.memorydata.plugin");
            IslandSessionUtils$Companion$showCalendar$2 r7 = (IslandSessionUtils$Companion$showCalendar$2) ZeusTransformUtils.preCheckCast(r5.L$0, IslandSessionUtils$Companion$showCalendar$2.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L25
            o r8 = r2;
            CoroutineContext.Element r9 = r1;
            Object r10 = null;
        L80:
            r5.L$0 = Unit.INSTANCE;     // Catch: Exception -> L76
            r5.L$1 = r10;     // Catch: Exception -> L76
            r5.L$2 = r10;     // Catch: Exception -> L76
            r5.label = 3;     // Catch: Exception -> L76
            if (r8.b(r9, r7) != r12) goto L79;
            return r12;
        L65:
            th = th;
        L72:
            r5.L$0 = th;     // Catch: Exception -> L76
            r5.L$1 = r10;     // Catch: Exception -> L76
            r5.L$2 = r10;     // Catch: Exception -> L76
            r5.L$3 = r10;     // Catch: Exception -> L76
            r5.label = 4;     // Catch: Exception -> L76
            if (r8.b(r9, r7) != r12) goto L75;
            return r12;
        L25:
            th = th;
            r8 = r2;
            r9 = r1;
            r10 = null;
            goto L72
        L27:
            CoroutineContext.Element r11 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r5.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            final IslandSession r13 = (IslandSession) ZeusTransformUtils.preCheckCast(r5.L$2, IslandSession.class, "com.obric.memorydata.plugin");
            o r14 = (o) ZeusTransformUtils.preCheckCast(r5.L$1, o.class, "com.obric.memorydata.plugin");
            IslandSessionUtils$Companion$showCalendar$2 r15 = (IslandSessionUtils$Companion$showCalendar$2) ZeusTransformUtils.preCheckCast(r5.L$0, IslandSessionUtils$Companion$showCalendar$2.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r4);     // Catch: Exception -> L76
            r8 = r14;
            IslandSessionUtils$Companion$showCalendar$2 r16 = r15;
            r9 = r11;
        L84:
            IslandSessionUtils.h().add(r13);     // Catch: Throwable -> L69
            IslandApi r17 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L69
            if (r17 == null) goto L55;
            Boxing.boxBoolean(r17.createSession(r13, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L69
        L55:
            Companion r18 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L69
            r5.L$0 = r16;     // Catch: Throwable -> L69
            r5.L$1 = r8;     // Catch: Throwable -> L69
            r5.L$2 = r9;     // Catch: Throwable -> L69
            r5.L$3 = null;     // Catch: Throwable -> L69
            r5.label = 2;     // Catch: Throwable -> L69
            r10 = null;
            if (a(r18, 0, r5, 1, null) != r12) goto L60;
            return r12;
        L60:
            r7 = r16;
        L67:
            th = th;
        L71:
            r7 = r16;
        L69:
            th = th;
            r10 = null;
            goto L71
        L30:
            ResultKt.throwOnFailure(r4);
            final PendingMemoryCalendar r19 = (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r45.d()), PendingMemoryCalendar.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L76
            if (r19 == null) goto L79;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "calendar eventType: " + r19.getEventType(), false, 4, null);     // Catch: Exception -> L76
            LiveCardType r32 = LiveCardType.MEMORY_DATA;     // Catch: Exception -> L76
            String r110 = r19.getTitle();     // Catch: Exception -> L76
            String r111 = r19.getEventType();     // Catch: Exception -> L76
            CalendarButton r20 = new CalendarButton("calendar_cancel", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_ignore, TypedValues.Custom.S_STRING, "memory_island_ignore")), IslandSessionUtils.f10217a.a(MemoryIslandTextColor.PRIMARY));     // Catch: Exception -> L76
            CalendarButton r21 = new CalendarButton("calendar_confirm", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_add_to_calendar, TypedValues.Custom.S_STRING, "memory_island_add_to_calendar")), IslandSessionUtils.f10217a.a(MemoryIslandTextColor.PRIMARY));     // Catch: Exception -> L76
            String r22 = r19.getLocation();     // Catch: Exception -> L76
            CharSequence r23 = (CharSequence) ZeusTransformUtils.preCheckCast(t.f10875a.a(r19), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L76
            if (r23.length() != 0) goto L36;
            boolean r112 = true;
        L37:
            if (r112 == false) goto L39;
            r23 = null;
        L39:
            r13 = new IslandSession(null, new CalendarExpandedTemplate(r110, r111, r20, r21, r22, (String) ZeusTransformUtils.preCheckCast(r23, String.class, "com.obric.memorydata.plugin")).create(Boxing.boxBoolean(true)), null, null, null, null, null, 0, r32, null, Boxing.boxBoolean(true), null, 1025, null, null, null, 0, 125693, null);     // Catch: Exception -> L76
            RunLog.INSTANCE.debug("IslandSessionUtils", "task id: " + r13.getTaskId());     // Catch: Exception -> L76
            IslandWidget r24 = r13.getExpandWidget();     // Catch: Exception -> L76
            if (r24 == null) goto L42;
            r24.addOnViewClickCallback("calendar_cancel", new $$Lambda$IslandSessionUtils$Companion$Ktt4hqX2M5D6A74ZmAKbUqRcHnc(r13));     // Catch: Exception -> L76
        L42:
            final Ref.BooleanRef r25 = new Ref.BooleanRef();     // Catch: Exception -> L76
            r25.element = true;     // Catch: Exception -> L76
            IslandWidget r26 = r13.getExpandWidget();     // Catch: Exception -> L76
            if (r26 == null) goto L45;
            r26.addOnViewClickCallback("calendar_confirm", new $$Lambda$IslandSessionUtils$Companion$QTT2DgOWIwcXpLhP3CT9BF79aA(r25, r13, r19));     // Catch: Exception -> L76
        L45:
            IslandWidget r27 = r13.getExpandWidget();     // Catch: Exception -> L76
            if (r27 == null) goto L48;
            r27.setOnCardClickCallback(new $$Lambda$IslandSessionUtils$Companion$SM6QrR5vw4GKtPM_vnD25MOJHU(r45, r13));     // Catch: Exception -> L76
        L48:
            o r28 = IslandSessionUtils.c();     // Catch: Exception -> L76
            r9 = r5.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L76
            r5.L$0 = r5;     // Catch: Exception -> L76
            r5.L$1 = r28;     // Catch: Exception -> L76
            r5.L$2 = r13;     // Catch: Exception -> L76
            r5.L$3 = r9;     // Catch: Exception -> L76
            r5.label = 1;     // Catch: Exception -> L76
            if (r28.a(r9, r5) != r12) goto L51;
            return r12;
        L51:
            r8 = r28;
            r16 = r5;
            goto L84
        L36:
            r112 = false;
        L76:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in showCalendar: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r5 = new IslandSessionUtils$Companion$showCalendar$2(this, r3);
            goto L8
        }

        public final Object a(Continuation<? super Unit> r19) {
            Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, IslandSessionUtils$Companion$destroyAll$1.class) == false) goto L7;
            IslandSessionUtils$Companion$destroyAll$1 r2 = (IslandSessionUtils$Companion$destroyAll$1) ZeusTransformUtils.preCheckCast(r0, IslandSessionUtils$Companion$destroyAll$1.class, "com.obric.memorydata.plugin");
            if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
            r2.label -= Integer.MIN_VALUE;
        L8:
            Object r1 = r2.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r2.label;
            if (r4 == 0) goto L24;
            if (r4 == 1) goto L21;
            if (r4 == 2) goto L18;
            if (r4 != 3) goto L14;
            Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r2.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r1);     // Catch: Exception -> L52
            throw r5;     // Catch: Exception -> L52
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            Unit r6 = (Unit) ZeusTransformUtils.preCheckCast(r2.L$0, Unit.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r1);     // Catch: Exception -> L52
        L55:
            return Unit.INSTANCE;
        L21:
            CoroutineContext.Element r7 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r2.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r9 = (o) ZeusTransformUtils.preCheckCast(r2.L$0, o.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r1);     // Catch: Exception -> L52
        L56:
            bx r8 = IslandSessionUtils.j();     // Catch: Throwable -> L46
            if (r8 == null) goto L32;
            bx.a.a(r8, null, 1, null);     // Catch: Throwable -> L46
        L32:
            Companion r10 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L46
            IslandSessionUtils.a(null);     // Catch: Throwable -> L46
            Companion r11 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L46
            IslandSessionUtils.a("");     // Catch: Throwable -> L46
            Companion r12 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L46
            IslandSessionUtils.a(null);     // Catch: Throwable -> L46
            Companion r13 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L46
            IslandSessionUtils.a(null);     // Catch: Throwable -> L46
            Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(IslandSessionUtils.h(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L46
        L34:
            if (r14.hasNext() == false) goto L42;
            IslandSession r15 = (IslandSession) ZeusTransformUtils.preCheckCast(r14.next(), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "destroyAll task id: " + r15.getTaskId(), false, 4, null);     // Catch: Throwable -> L46
            IslandApi r16 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Exception -> L40 Throwable -> L46
            if (r16 == null) goto L34;
            r16.destroySession(r15);     // Catch: Exception -> L40 Throwable -> L46
        L40:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error destroying session: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L46
            goto L34
        L42:
            IslandSessionUtils.h().clear();     // Catch: Throwable -> L46
            r2.L$0 = Unit.INSTANCE;     // Catch: Exception -> L52
            r2.L$1 = null;     // Catch: Exception -> L52
            r2.label = 2;     // Catch: Exception -> L52
            if (r9.b(r7, r2) != r3) goto L55;
            return r3;
        L46:
            th = move-exception;
            r2.L$0 = th;     // Catch: Exception -> L52
            r2.L$1 = null;     // Catch: Exception -> L52
            r2.label = 3;     // Catch: Exception -> L52
            if (r9.b(r7, r2) != r3) goto L51;
            return r3;
        L51:
            throw th;     // Catch: Exception -> L52
        L24:
            ResultKt.throwOnFailure(r1);
            r9 = IslandSessionUtils.c();     // Catch: Exception -> L52
            r7 = r2.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L52
            r2.L$0 = r9;     // Catch: Exception -> L52
            r2.L$1 = r7;     // Catch: Exception -> L52
            r2.label = 1;     // Catch: Exception -> L52
            if (r9.a(r7, r2) != r3) goto L56;
            return r3;
        L52:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in destroyAll: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r2 = new IslandSessionUtils$Companion$destroyAll$1(this, r0);
            goto L8
        }

        public final void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "showEffect ...", false, 4, null);
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Companion r9 = (Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            Object r10 = Result.m1421constructorimpl(ZeusProviderTransform.call(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.assistantaiagent.provider.HybridAbilityProvider"), "show_screen_shot_effect", null, null, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
        L7:
            Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
            if (r11 == null) goto L13;
            RunLog.INSTANCE.error("IslandSessionUtils", "showEffect error: " + r11.getMessage(), r11);
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final void a(MemoryEntity r9, MemoryEntity r10, List<PendingMemoryCalendar> r11) {
            List<PendingMemoryCalendar> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "entity");
            Intrinsics.checkNotNullParameter(r12, "calendars");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "entity type: " + r9.getType() + ", calendars size: " + r12.size(), false, 4, null);
            b r8 = b(r9, r10, r12);     // Catch: Exception -> L7
            if (r8 == null) goto L12;
            i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showCalendar$1$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Exception -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in showCalendar: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void a(com.obric.memorydata.memory.island.c r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r11, "summary");
            IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
            StringBuilder r1 = new StringBuilder().append("showBatchMemorySummary id=").append(r11.a()).append(", state=").append(r12).append(", total=").append(r11.b()).append(", success=").append(r11.f()).append(", failure=").append(r11.c()).append(", groups=");     // Catch: Exception -> L30
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r11.d(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
            Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
            Iterator r6 = r4.iterator();     // Catch: Exception -> L30
        L5:
            if (r6.hasNext() == false) goto L10;
            Object r7 = r6.next();     // Catch: Exception -> L30
            BatchMemoryIslandKind r8 = ((com.obric.memorydata.memory.island.b) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.memory.island.b.class, "com.obric.memorydata.plugin")).a();     // Catch: Exception -> L30
            Object r9 = r5.get(r8);     // Catch: Exception -> L30
            if (r9 != null) goto L9;
            r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
            r5.put(r8, r9);     // Catch: Exception -> L30
        L9:
            ((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin")).add(r7);     // Catch: Exception -> L30
            goto L5
        L10:
            Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r5.size())), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
            Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L30
        L12:
            if (r14.hasNext() == false) goto L14;
            Object r15 = r14.next();     // Catch: Exception -> L30
            r10.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r15, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.valueOf(((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")).size()));     // Catch: Exception -> L30
            goto L12
        L14:
            IRunLog.a.a(r2, "IslandSessionUtils", r1.append(r10).toString(), false, 4, null);     // Catch: Exception -> L30
            if (r12 == State.SUCCESS_NEW.ordinal()) goto L26;
            if (r12 == State.SUCCESS_UPDATE.ordinal()) goto L26;
            if (r12 != State.TIMEOUT.ordinal()) goto L22;
        L23:
            String r16 = r11.a();     // Catch: Exception -> L30
        L24:
            c(r16);     // Catch: Exception -> L30
            return;
        L22:
            if (r12 == State.FAILURE_ERROR.ordinal()) goto L23;
            return;
        L26:
            if (r11.f() <= 0) goto L28;
            a(r11, r13);     // Catch: Exception -> L30
            return;
        L28:
            r16 = r11.a();     // Catch: Exception -> L30
        L30:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in showBatchMemorySummary: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void a(String r16) {
            Intrinsics.checkNotNullParameter(r16, OaidModel.KEY_ID);
            String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_cancelled, TypedValues.Custom.S_STRING, "memory_island_memory_cancelled"));
            Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "showMemoryCancelled " + r16, false, 4, null);
            a(this, r16, a(this, a(r9, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, null, 14, null), a(this, a(r9, 18, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), MemoryIslandTextColor.PRIMARY), null, null, 6, null), false, true, null, null, 3000L, true, 64, null);
        }

        public final void a(String r17, int r18, MemoryEntity r19, MemoryEntity r20, boolean r21, List<PendingMemoryCalendar> r22) {
            List<PendingMemoryCalendar> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r17, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r5, "calendars");
            IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L29
            StringBuilder r2 = new StringBuilder().append("id: ").append(r17).append(", entity type: ");     // Catch: Exception -> L29
            if (r19 == null) goto L6;
            Integer r3 = Integer.valueOf(r19.getType());     // Catch: Exception -> L29
        L7:
            IRunLog.a.a(r10, "IslandSessionUtils", r2.append(r3).append(", state: ").append(r18).append(", calendars size: ").append(r5.size()).append(", needEffect: ").append(r21).toString(), false, 4, null);     // Catch: Exception -> L29
            if (r18 != State.BEGIN.ordinal()) goto L11;
            a(r17, r21);     // Catch: Exception -> L29
            return;
        L11:
            if (r18 != State.SUCCESS_NEW.ordinal()) goto L17;
            if (r19 == null) goto L14;
        L13:
            a(this, r17, r19, null, r5, r21, 4, null);     // Catch: Exception -> L29
            return;
        L14:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "SUCCESS_NEW, but entity is null!", null, 4, null);     // Catch: Exception -> L29
        L15:
            c(r17);     // Catch: Exception -> L29
            return;
        L17:
            if (r18 != State.SUCCESS_UPDATE.ordinal()) goto L25;
            if (r19 == null) goto L21;
            if (r20 == null) goto L21;
            a(r17, r19, r20, r5, r21);     // Catch: Exception -> L29
            return;
        L21:
            if (r19 == null) goto L23;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "SUCCESS_UPDATE, but oldEntity is null!", null, 4, null);     // Catch: Exception -> L29
            goto L13
        L23:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "SUCCESS_UPDATE, but entity and oldEntity are both null!", null, 4, null);     // Catch: Exception -> L29
            goto L15
        L25:
            if (r18 == State.TIMEOUT.ordinal()) goto L15;
            if (r18 == State.FAILURE_ERROR.ordinal()) goto L15;
            return;
        L6:
            r3 = null;
        L29:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtils", "Error in showMemory: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void a(String r15, MemoryCollapseTemplate r16, Object r17, boolean r18, boolean r19, b r20, Map<String, b> r21, Long r22, boolean r23) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r16, "collapseWidgetData");
            Intrinsics.checkNotNullParameter(r17, "expandWidgetData");
            Intrinsics.checkNotNullParameter(r8, "batchActionContents");
            i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showIslandWidget$1(r20, r22, r15, r23, r17, r8, r16, r19, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }
    }

    static {
        f10217a = new Companion(null);
        f10218b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        c = "";
        g = q.a(false, 1, null);
        h = System.currentTimeMillis();
        i = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("IslandSessionUtils"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        j = $$Lambda$IslandSessionUtils$HRdVDDLxlXD4HfSqCbrahdcuL9k.INSTANCE;
        k = (Function1) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$ON_DISMISS_CALLBACK$1(null), Function1.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Companion.MemoryExpandTemplateType a() {
        return e;
    }

    public static final /* synthetic */ void a(long r0) {
        h = r0;
    }

    public static final /* synthetic */ void a(Companion.MemoryExpandTemplateType r0) {
        e = r0;
    }

    public static final /* synthetic */ void a(Companion.b r0) {
        d = r0;
    }

    public static final /* synthetic */ void a(Long r0) {
        l = r0;
    }

    public static final /* synthetic */ void a(String r0) {
        c = r0;
    }

    public static final /* synthetic */ void a(bx r2) {
        f = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ al b() {
        return i;
    }

    public static final /* synthetic */ o c() {
        return g;
    }

    public static final /* synthetic */ Function0 d() {
        return j;
    }

    public static final /* synthetic */ String e() {
        return c;
    }

    public static final /* synthetic */ long f() {
        return h;
    }

    public static final /* synthetic */ Long g() {
        return l;
    }

    public static final /* synthetic */ List h() {
        return f10218b;
    }

    public static final /* synthetic */ Companion.b i() {
        return d;
    }

    public static final /* synthetic */ bx j() {
        return f;
    }

    public static final /* synthetic */ Function1 k() {
        return k;
    }

    private static final Unit l() {
        i.a(i, null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$HRdVDDLxlXD4HfSqCbrahdcuL9k() {
        return l();
    }
}
