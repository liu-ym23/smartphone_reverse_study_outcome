package com.obric.memorydata.memory.ui.detail;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
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
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailGlobalBinding;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.llm.SessionStatus;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.list.FlowLayout;
import com.obric.memorydata.memory.ui.list.MemorySourceIconScene;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.App;
import com.obric.memorydata.middleware.api.settings.Extras;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.aq;
import com.obric.memorydata.utils.ba;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J$\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u00112\b\b\u0003\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J7\u0010#\u001a\u00020$*\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110&0%2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110(\"\u00020\u0011H\u0002¢\u0006\u0002\u0010)J@\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110&2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110&0%2\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110&0%J:\u0010-\u001a\u00020$2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110&0%2\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110&0%J:\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020$2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110&0%2\u0006\u00102\u001a\u00020$H\u0016J\u0006\u00103\u001a\u00020\u0007J\u0018\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0016H\u0002J\"\u0010:\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00112\b\b\u0002\u0010<\u001a\u00020$H\u0003J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020$H\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/GlobalMemoryViewHolder;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewHolder;", "Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailGlobalBinding;", "binding", "onSendCapsuleEvent", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter$CapsuleEvent;", "", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailGlobalBinding;Lkotlin/jvm/functions/Function1;)V", "getOnSendCapsuleEvent", "()Lkotlin/jvm/functions/Function1;", "updater", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/memorydata/markdown/stream/MarkdownTextViewUpdater;", "currentStreamFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "bind", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "bindHeader", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$DetailEntity;", "bindMeta", "capsuleViews", "", "Landroid/view/View;", "createCapsuleView", ObricMemoryConstants.KEY_PACKAGE_NAME, "type", "defaultIconRes", "", "getPackageNameForType", "pkgName", "getInsertIndex", "hasValidValues", "", "", "", "keys", "", "(Ljava/util/Map;[Ljava/lang/String;)Z", "findMapDifferences", "map1", "map2", "hasMapDifferences", "bindCapsule", "item", "showCalendar", "keyInfoMap", "showAnimation", "clearCapsules", "openSourceLink", "context", "Landroid/content/Context;", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "bindSummary", "renderWithStream", "summaryText", "firstRenderAll", "setMarkdownVisible", "visible", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends x<ItemMemoryDetailGlobalBinding> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10855a = null;
    private static final List<String> x = null;
    private final Function1<u.a, Unit> t;
    private AtomicReference<com.obric.memorydata.markdown.stream.h> u;
    private ar<String> v;
    private final Map<String, View> w;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/GlobalMemoryViewHolder$Companion;", "", "<init>", "()V", "CAPSULE_SOURCE", "", "CAPSULE_CALENDAR", "CAPSULE_PHONE", "CAPSULE_ADDRESS", "CAPSULE_URL", "CAPSULE_ORDER", "", "getSummary", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a(MemoryEntity r20) {
            Intrinsics.checkNotNullParameter(r20, "entity");
            StringBuilder r1 = new StringBuilder();
            boolean r7 = false;
            if (ZeusTransformUtils.instanceOf(r20, OrderFlightMemoryEntity.class) == false) goto L51;
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureAirport(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L21;
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingAirport(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L15;
        L18:
            boolean r5 = true;
        L19:
            if (r5 == true) goto L21;
            r1.append(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureAirport() + " - " + ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingAirport() + '\n');
            goto L21
        L15:
            if (r4.length() == 0) goto L18;
            r5 = false;
        L21:
            String r6 = v.f10881a.a((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L24;
            boolean r8 = true;
        L25:
            if (r8 == false) goto L27;
            r1.append(r6).append("\n");
        L27:
            List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L30;
            boolean r10 = true;
        L31:
            if (r10 == false) goto L33;
            r9.add(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber());
        L33:
            String r11 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getBoardingGate();
            if (r11 == null) goto L36;
            r9.add(r11);
        L36:
            List<String> r0 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
            if (r0 == null) goto L48;
            Iterator<String> r12 = r0.iterator();
        L40:
            if (r12.hasNext() == false) goto L48;
            String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L44;
            boolean r14 = true;
        L45:
            if (r14 == false) goto L40;
            r9.add(r13);
            goto L40
        L44:
            r14 = false;
        L48:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L258;
        L49:
            String r15 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        L211:
            r1.append(r15);
        L258:
            String r16 = r1.toString();
            Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
            return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        L30:
            r10 = false;
            goto L31
        L24:
            r8 = false;
            goto L25
        L7:
            if (r2.length() == 0) goto L10;
            r3 = false;
            goto L11
        L51:
            if (ZeusTransformUtils.instanceOf(r20, OrderTrainMemoryEntity.class) == false) goto L112;
            CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureStation(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r17 != null) goto L55;
        L58:
            boolean r18 = true;
        L59:
            if (r18 == true) goto L69;
            CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalStation(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r19 != null) goto L63;
        L66:
            boolean r21 = true;
        L67:
            if (r21 == true) goto L69;
            r1.append(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureStation() + " - " + ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalStation() + '\n');
            goto L69
        L63:
            if (r19.length() == 0) goto L66;
            r21 = false;
        L69:
            String r22 = v.f10881a.a((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L72;
            boolean r23 = true;
        L73:
            if (r23 == false) goto L75;
            r1.append(r22).append("\n");
        L75:
            r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L78;
            boolean r24 = true;
        L79:
            if (r24 == false) goto L81;
            r9.add(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber());
        L81:
            List<String> r25 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
            if (r25 != null) goto L84;
            r25 = CollectionsKt.emptyList();
        L84:
            List<String> r26 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getPassengerName();
            if (r26 != null) goto L87;
            r26 = CollectionsKt.emptyList();
        L87:
            int r27 = Math.max(r25.size(), r26.size());
            int r28 = 0;
        L88:
            if (r28 >= r27) goto L109;
            String r110 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r25, r28), String.class, "com.obric.memorydata.plugin");
            String r111 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r26, r28), String.class, "com.obric.memorydata.plugin");
            CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.memorydata.plugin");
            if (r112 != null) goto L92;
        L95:
            boolean r113 = true;
        L96:
            if (r113 == true) goto L98;
            r9.add(r110);
        L98:
            CharSequence r114 = (CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.memorydata.plugin");
            if (r114 != null) goto L101;
        L104:
            boolean r115 = true;
        L105:
            if (r115 == true) goto L107;
            r9.add(r111);
        L107:
            r28 = r28 + 1;
            goto L88
        L101:
            if (r114.length() == 0) goto L104;
            r115 = false;
            goto L105
        L92:
            if (r112.length() == 0) goto L95;
            r113 = false;
            goto L96
        L109:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L258;
        L78:
            r24 = false;
            goto L79
        L72:
            r23 = false;
            goto L73
        L55:
            if (r17.length() == 0) goto L58;
            r18 = false;
            goto L59
        L112:
            if (ZeusTransformUtils.instanceOf(r20, OrderHotelMemoryEntity.class) == false) goto L127;
            String r29 = v.f10881a.a((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L116;
            boolean r30 = true;
        L117:
            if (r30 == false) goto L119;
            r1.append(r29).append("\n");
        L119:
            CharSequence r31 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelAddress(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r31 != null) goto L122;
        L123:
            r7 = true;
        L124:
            if (r7 == true) goto L258;
            r15 = ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelAddress();
            goto L211
        L122:
            if (r31.length() != 0) goto L124;
        L116:
            r30 = false;
            goto L117
        L127:
            if (ZeusTransformUtils.instanceOf(r20, OrderMovieTicketMemoryEntity.class) == false) goto L168;
            List r32 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            String r33 = ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieHallNumber();
            if (r33 == null) goto L131;
            r32.add(r33);
        L131:
            List<String> r34 = ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
            if (r34 == null) goto L143;
            Iterator<String> r35 = r34.iterator();
        L135:
            if (r35.hasNext() == false) goto L143;
            String r36 = (String) ZeusTransformUtils.preCheckCast(r35.next(), String.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r36, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L139;
            boolean r116 = true;
        L140:
            if (r116 == false) goto L135;
            r32.add(r36);
            goto L135
        L139:
            r116 = false;
        L143:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r32, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L145;
            r1.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append("\n");
        L145:
            String r37 = v.f10881a.a((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L148;
            boolean r38 = true;
        L149:
            if (r38 == false) goto L151;
            r1.append(r37).append("\n");
        L151:
            CharSequence r39 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterName(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r39 != null) goto L154;
        L157:
            boolean r40 = true;
        L158:
            if (r40 == true) goto L160;
            r1.append(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterName()).append("\n");
        L160:
            CharSequence r41 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterAddress(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r41 != null) goto L163;
        L164:
            r7 = true;
        L165:
            if (r7 == true) goto L258;
            r15 = ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterAddress();
            goto L211
        L163:
            if (r41.length() != 0) goto L165;
        L154:
            if (r39.length() == 0) goto L157;
            r40 = false;
            goto L158
        L148:
            r38 = false;
            goto L149
        L168:
            if (ZeusTransformUtils.instanceOf(r20, OrderTicketMemoryEntity.class) == false) goto L209;
            List r42 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            String r43 = ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getHallNumber();
            if (r43 == null) goto L172;
            r42.add(r43);
        L172:
            List<String> r44 = ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
            if (r44 == null) goto L184;
            Iterator<String> r45 = r44.iterator();
        L176:
            if (r45.hasNext() == false) goto L184;
            String r46 = (String) ZeusTransformUtils.preCheckCast(r45.next(), String.class, "com.obric.memorydata.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r46, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L180;
            boolean r117 = true;
        L181:
            if (r117 == false) goto L176;
            r42.add(r46);
            goto L176
        L180:
            r117 = false;
        L184:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r42, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L186;
            r1.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r42, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append("\n");
        L186:
            String r47 = v.f10881a.a((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r47, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L189;
            boolean r48 = true;
        L190:
            if (r48 == false) goto L192;
            r1.append(r47).append("\n");
        L192:
            CharSequence r49 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumName(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r49 != null) goto L195;
        L198:
            boolean r50 = true;
        L199:
            if (r50 == true) goto L201;
            r1.append(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumName()).append("\n");
        L201:
            CharSequence r51 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumAddress(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r51 != null) goto L204;
        L205:
            r7 = true;
        L206:
            if (r7 == true) goto L258;
            r15 = ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumAddress();
            goto L211
        L204:
            if (r51.length() != 0) goto L206;
        L195:
            if (r49.length() == 0) goto L198;
            r50 = false;
            goto L199
        L189:
            r48 = false;
            goto L190
        L209:
            if (ZeusTransformUtils.instanceOf(r20, OrderCommonMemoryEntity.class) == false) goto L213;
            r15 = ((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getOrderDesc();
            goto L211
        L213:
            if (ZeusTransformUtils.instanceOf(r20, CollectStoreMemoryEntity.class) == false) goto L222;
            CharSequence r52 = (CharSequence) ZeusTransformUtils.preCheckCast(((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r20, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r52 != null) goto L217;
        L218:
            r7 = true;
        L219:
            if (r7 == true) goto L258;
            r15 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r20, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress();
            goto L211
        L217:
            if (r52.length() != 0) goto L219;
        L222:
            if (ZeusTransformUtils.instanceOf(r20, EventScheduleMemoryEntity.class) == false) goto L237;
            String r53 = v.f10881a.a((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r53, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L226;
            boolean r54 = true;
        L227:
            if (r54 == false) goto L229;
            r1.append(r53).append("\n");
        L229:
            CharSequence r55 = (CharSequence) ZeusTransformUtils.preCheckCast(((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress(), CharSequence.class, "com.obric.memorydata.plugin");
            if (r55 != null) goto L232;
        L233:
            r7 = true;
        L234:
            if (r7 == true) goto L258;
            r15 = ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress();
            goto L211
        L232:
            if (r55.length() != 0) goto L234;
        L226:
            r54 = false;
            goto L227
        L237:
            if (ZeusTransformUtils.instanceOf(r20, EventTodoMemoryEntity.class) == false) goto L244;
            String r56 = v.f10881a.a((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r56, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L241;
            r7 = true;
        L241:
            if (r7 == false) goto L258;
            r1.append(r56).append("\n");
            goto L258
        L244:
            if (ZeusTransformUtils.instanceOf(r20, CollectContentMemoryEntity.class) == false) goto L247;
            r15 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r20, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary();
            goto L211
        L247:
            if (ZeusTransformUtils.instanceOf(r20, CommonTextMemoryEntity.class) == false) goto L250;
            r15 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r20, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary();
            goto L211
        L250:
            if (ZeusTransformUtils.instanceOf(r20, InfoDocumentsMemoryEntity.class) == true) goto L258;
            if (ZeusTransformUtils.instanceOf(r20, InfoAddressMemoryEntity.class) == true) goto L258;
            if (ZeusTransformUtils.instanceOf(r20, InfoAnniversaryMemoryEntity.class) == true) goto L258;
            if (ZeusTransformUtils.instanceOf(r20, InfoRelationshipMemoryEntity.class) == true) goto L258;
            ZeusTransformUtils.instanceOf(r20, InfoCommonMemoryEntity.class);
            goto L258
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10856a = null;

        static {
            int[] r0 = new int[SessionStatus.values().length];
            r0[SessionStatus.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[SessionStatus.STREAMING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[SessionStatus.COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[SessionStatus.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[SessionStatus.ILLEGAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f10856a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/detail/GlobalMemoryViewHolder$createCapsuleView$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r4, Outline r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "outline");
            r5.setOval(r4.getPaddingLeft(), r4.getPaddingTop(), r4.getWidth() - r4.getPaddingRight(), r4.getHeight() - r4.getPaddingBottom());
        }
    }

    static {
        f10855a = new a(null);
        x = CollectionsKt.listOf(new String[]{AILabCheckPermissionTask.KEY_SOURCE, "calendar", MemoryKeyInfoEntity.KEY_PHONE, MemoryKeyInfoEntity.KEY_ADDRESS, "url"});
    }

    public f(ItemMemoryDetailGlobalBinding r3, Function1<? super u.a, Unit> r4) {
        Function1<u.a, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r5, "onSendCapsuleEvent");
        super((ViewBinding) ZeusTransformUtils.preCheckCast(r3, ViewBinding.class, "com.obric.memorydata.plugin"));
        this.t = r5;
        this.u = new AtomicReference(null);
        this.w = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private final int a(String r9) {
        int r10 = x.indexOf(r9);
        if (r10 == (-1)) goto L5;
        int r1 = 0;
        int r2 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.getChildCount();
    L7:
        if (r1 >= r2) goto L5;
        View r3 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.getChildAt(r1);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.w.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        String r6 = null;
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), r3) == false) goto L9;
    L15:
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        r6 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin");
    L18:
        if (r6 == null) goto L22;
        if (x.indexOf(r6) <= r10) goto L22;
        return r1;
    L22:
        r1 = r1 + 1;
        goto L7
    L14:
        r5 = null;
    L5:
        return ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.getChildCount();
    }

    static /* synthetic */ View a(f r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = com.obric.memorydata.utils.icon.b.f13229a.a();
    L6:
        return r0.a(r1, r2, r3);
    }

    private final View a(String r6, String r7, int r8) {
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.item_capsule, "layout", "item_capsule"), (ViewGroup) ZeusTransformUtils.preCheckCast(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.capsule_icon, OaidModel.KEY_ID, "capsule_icon")), ImageView.class, "com.obric.memorydata.plugin");
        r10.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new c(), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        r10.setClipToOutline(true);
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.capsule_text, OaidModel.KEY_ID, "capsule_text")), TextView.class, "com.obric.memorydata.plugin");
        switch(r7.hashCode()) {
            case -1147692044: goto L22;
            case -896505829: goto L18;
            case -178324674: goto L14;
            case 116079: goto L10;
            case 106642798: goto L6;
            default: goto L26;
        };
    L26:
        Intrinsics.checkNotNull(r9);
        return r9;
    L6:
        if (r7.equals(MemoryKeyInfoEntity.KEY_PHONE) == false) goto L26;
        r10.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_key_phone, "drawable", "ic_key_phone"));
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_capsule_call_phone, TypedValues.Custom.S_STRING, "memory_detail_capsule_call_phone")), CharSequence.class, "com.obric.memorydata.plugin"));
        View.OnClickListener r11 = new $$Lambda$f$NMcU4NUkvj5eKjYebkrVcc4NzJE(this);
    L25:
        r9.setOnClickListener(r11);
        goto L26
    L10:
        if (r7.equals("url") == false) goto L26;
        r10.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_key_url, "drawable", "ic_key_url"));
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_capsule_open_url, TypedValues.Custom.S_STRING, "memory_detail_capsule_open_url")), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = new $$Lambda$f$aVhti7RgGYlxaoDX8C3W6lu8oXw(this);
        goto L25
    L14:
        if (r7.equals("calendar") == false) goto L26;
        r10.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_key_calendar, "drawable", "ic_key_calendar"));
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_capsule_create_schedule, TypedValues.Custom.S_STRING, "memory_detail_capsule_create_schedule")), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = new $$Lambda$f$PpMGfgAqScWlcV1WW6pQxE9N0nw(this);
        goto L25
    L18:
        if (r7.equals(AILabCheckPermissionTask.KEY_SOURCE) == false) goto L26;
        r10.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_key_source, "drawable", "ic_key_source"));
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_capsule_view_source, TypedValues.Custom.S_STRING, "memory_detail_capsule_view_source")), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = new $$Lambda$f$V_BkY6mlDVRfi8YMo_6epM9ojBk(this);
        goto L25
    L22:
        if (r7.equals(MemoryKeyInfoEntity.KEY_ADDRESS) == false) goto L26;
        r10.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_key_address, "drawable", "ic_key_address"));
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_detail_capsule_view_route, TypedValues.Custom.S_STRING, "memory_detail_capsule_view_route")), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = new $$Lambda$f$GFsDtQ1VrIWXCbH03SpqkzmRH38(this);
        goto L25
    }

    private static final com.obric.memorydata.markdown.stream.h a(com.obric.memorydata.markdown.stream.h r0) {
        if (r0 == null) goto L6;
        r0.b();
        return null;
    L6:
        return null;
    }

    private static final com.obric.memorydata.markdown.stream.h a(f r42, com.obric.memorydata.markdown.stream.h r43) {
        if (r43 == null) goto L4;
        r43.b();
    L4:
        com.obric.memorydata.markdown.stream.h.a r0 = com.obric.memorydata.markdown.stream.h.f10021a;
        MarkdownTextView r1 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r42.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryText;
        Intrinsics.checkNotNullExpressionValue(r1, "summaryText");
        return com.obric.memorydata.markdown.stream.h.a.a(r0, r1, new com.larus.business.markdown.api.model.c(0, null, CollectionsKt.listOf(new com.obric.memorydata.memory.ui.detail.b[]{new ab(), new com.obric.memorydata.memory.ui.detail.a(), new r(), new h()}), null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 12, Resources.getSystem().getDisplayMetrics()))), Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 4, Resources.getSystem().getDisplayMetrics()))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98309, null), null, 4, null);
    }

    private final String a(String r1, String r2) {
        if (Intrinsics.areEqual(r1, AILabCheckPermissionTask.KEY_SOURCE) == false) goto L6;
        return r2;
    L6:
        if (Intrinsics.areEqual(r1, "calendar") == true) goto L10;
        return null;
    L10:
        return AppInfo.Calendar.getPackageName();
    }

    private static final Unit a(f r2) {
        r2.w.clear();
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r2.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.removeAllViews();
        return Unit.INSTANCE;
    }

    private static final Unit a(f r20, boolean r21) {
        ViewGroup.MarginLayoutParams r7 = null;
        OUIFrameLayout r11 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowWrapper;
        if (r21 == false) goto L11;
        float r12 = (float) 21.33d;
        r11.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())), 0, 0);
        ImageView r8 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).imageSource;
        Intrinsics.checkNotNullExpressionValue(r8, "imageSource");
        y.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, Resources.getSystem().getDisplayMetrics())), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_line_1, TypedValues.Custom.S_COLOR, "oui_basic_line_1")), TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics()), TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics()), 0.0f, 0.0f);
        OUIFrameLayout r2 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowView;
        ViewGroup.LayoutParams r3 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowView.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L8:
        if (r4 == null) goto L10;
        r4.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        r7 = r4;
    L10:
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r0 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).line;
        Intrinsics.checkNotNullExpressionValue(r0, "line");
        com.obric.oui.common.util.o.a(r0, true);
    L19:
        return Unit.INSTANCE;
    L7:
        r4 = null;
        goto L8
    L11:
        float r13 = 16;
        r11.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics())));
        ImageView r14 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).imageSource;
        Intrinsics.checkNotNullExpressionValue(r14, "imageSource");
        y.a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, Resources.getSystem().getDisplayMetrics())), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_line_1, TypedValues.Custom.S_COLOR, "oui_basic_line_1")), TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics()), TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics()), TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics()), TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics()));
        OUIFrameLayout r5 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowView;
        ViewGroup.LayoutParams r6 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowView.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L14;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L15:
        if (r9 == null) goto L17;
        r9.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics()));
        r7 = r9;
    L17:
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r1 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r20.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).line;
        Intrinsics.checkNotNullExpressionValue(r1, "line");
        com.obric.oui.common.util.o.a(r1, false);
        goto L19
    L14:
        r9 = null;
        goto L15
    }

    private final void a(Context r12, MemoryEntity r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        String r0 = r13.getSourcePackageName();
        if (r0 != null) goto L5;
        return;
    L5:
        Object r4 = null;
        if (r13.getProductType() != 6) goto L12;
        a((AppEntity) ZeusTransformUtils.preCheckCast(r13, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.ORIGIN_PAGE);
        LinearLayout r15 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot();
        Intrinsics.checkNotNullExpressionValue(r15, "getRoot(...)");
        LifecycleCoroutineScope r16 = y.a((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"));
        if (r16 == null) goto L70;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r16, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new GlobalMemoryViewHolder$openSourceLink$1(this, r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L70:
        return;
    L12:
        if (com.obric.memorydata.utils.c.f13193a.a(r0) == false) goto L63;
        String r2 = r13.getSourceLink();
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L16;
    L19:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L25;
        ComponentName r1 = com.obric.memorydata.utils.c.f13193a.a(r14, r0);
        if (r1 == null) goto L71;
        Intent r6 = new Intent();
        r6.setComponent(r1);
        r6.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        a((AppEntity) ZeusTransformUtils.preCheckCast(r13, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.ORIGIN_APP);
        com.obric.memorydata.memory.utils.f.f11537a.a(r14, r6);
        return;
    L71:
        return;
    L25:
        a((AppEntity) ZeusTransformUtils.preCheckCast(r13, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.ORIGIN_PAGE);
        String r11 = r13.getSourceLinkType();
        if (Intrinsics.areEqual(r11, MemorySourceLinkType.DEEPLINK) == false) goto L28;
    L31:
        Intent r17 = new Intent("android.intent.action.VIEW", Uri.parse(r2));
    L32:
        r17.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (Intrinsics.areEqual(r13.getSourceLinkType(), "url") == false) goto L62;
        SettingsManager r18 = SettingsManager.INSTANCE;
        String r7 = r18.getSettingsStr(SettingsManager.KEY_PAGE_CONTEXT_SETTINGS);
        if (r7 != null) goto L65;
    L36:
        Object r19 = null;
    L41:
        com.obric.memorydata.middleware.impl.settings.g r110 = (com.obric.memorydata.middleware.impl.settings.g) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.middleware.impl.settings.g.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L58;
        List<App> r111 = r110.c();
        if (r111 == null) goto L58;
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L47:
        if (r112.hasNext() == false) goto L51;
        Object r8 = r112.next();
        if (Intrinsics.areEqual(((App) ZeusTransformUtils.preCheckCast(r8, App.class, "com.obric.memorydata.plugin")).getPackageName(), r0) == false) goto L47;
        r4 = r8;
    L51:
        App r113 = (App) ZeusTransformUtils.preCheckCast(r4, App.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L58;
        Extras r114 = r113.getExtras();
        if (r114 == null) goto L58;
        String r115 = r114.getUrlMode();
        if (r115 == null) goto L58;
    L60:
        if (Intrinsics.areEqual(r115, "self") == false) goto L62;
        ae.f10847a.a(r14, r17, r0);
    L58:
        r115 = "default";
        goto L60
    L65:
        r19 = r18.getGSON().fromJson(r7, com.obric.memorydata.middleware.impl.settings.g.class);     // Catch: Exception -> L39
    L39:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
    L62:
        com.obric.memorydata.memory.utils.f.f11537a.a(r14, r17);
        return;
    L28:
        if (Intrinsics.areEqual(r11, "url") == true) goto L31;
        r17 = com.obric.memorydata.memory.s.f10512a.a(r2);
        goto L32
    L16:
        if (r3.length() == 0) goto L19;
        r5 = false;
        goto L21
    L63:
        a((AppEntity) ZeusTransformUtils.preCheckCast(r13, AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.MARKET);
        com.obric.memorydata.utils.d r116 = com.obric.memorydata.utils.d.f13204a;
        Context r117 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type android.app.Activity");
        r116.b((Context) ZeusTransformUtils.preCheckCast((Activity) ZeusTransformUtils.preCheckCast(r117, Activity.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0);
    }

    private static final void a(MemoryEntity r5, f r6, FileEntity r7, View r8) {
        MemoryEventTracker r9 = MemoryEventTracker.f10515a;
        AppEntity r10 = (AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.memorydata.plugin");
        int r0 = MemoryEventTracker.ReactionType.IMAGE.getValue();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r6.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r2), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BaseMemoryActivity.class) == false) goto L5;
        BaseMemoryActivity r4 = (BaseMemoryActivity) ZeusTransformUtils.preCheckCast(r3, BaseMemoryActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L9;
        String r11 = r4.getEnterFrom();
        if (r11 == null) goto L9;
    L10:
        r9.a(r10, r0, r11);
        com.obric.memorydata.memory.utils.f r12 = com.obric.memorydata.memory.utils.f.f11537a;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r6.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "getContext(...)");
        r12.a(r13, r7);
        return;
    L9:
        r11 = "";
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private final void a(com.obric.memorydata.memory.ui.data.a.e r17) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "bindHeader", false, 4, null);
        final MemoryEntity r1 = r17.b();
        final String r2 = r1.getSourceText();
        final FileEntity r4 = r1.getScreenshot();
        String r5 = r1.getSourceQuery();
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowView.setShadowStyle(ZeusTransformUtils.mapRes(R.style.OUIShadow_2_1, "style", "OUIShadow_2_1"));
        boolean r7 = true;
        if (r4 != null) goto L14;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L7;
    L10:
        boolean r10 = true;
    L11:
        if (r10 == false) goto L14;
        FrameLayout r0 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).headerContainer;
        Intrinsics.checkNotNullExpressionValue(r0, "headerContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), false);
        return;
    L7:
        if (r9.length() == 0) goto L10;
        r10 = false;
    L14:
        if (r4 != null) goto L44;
        View r3 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).line;
        Intrinsics.checkNotNullExpressionValue(r3, "line");
        com.obric.oui.common.util.o.a(r3, false);
        FrameLayout r6 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).headerContainer;
        GradientDrawable r8 = new GradientDrawable();
        r8.setColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2")));
        r8.setCornerRadius(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics()));
        r6.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r8, Drawable.class, "com.obric.memorydata.plugin"));
        View r11 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).viewOverlay;
        Intrinsics.checkNotNullExpressionValue(r11, "viewOverlay");
        com.obric.oui.common.util.o.a(r11, true);
        LinearLayout r12 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvSourceContentContainer;
        Intrinsics.checkNotNullExpressionValue(r12, "tvSourceContentContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), true);
        ImageView r13 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).imageSource;
        Intrinsics.checkNotNullExpressionValue(r13, "imageSource");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"), false);
        FrameLayout r14 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).headerContainer;
        Intrinsics.checkNotNullExpressionValue(r14, "headerContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"), true);
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L18;
    L21:
        boolean r16 = true;
    L22:
        if (r16 == false) goto L31;
        TextView r18 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvSourceContent;
        Intrinsics.checkNotNullExpressionValue(r18, "tvSourceContent");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"), true);
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvSourceContent.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        ChatListView r19 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).chatListView;
        Intrinsics.checkNotNullExpressionValue(r19, "chatListView");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r19, View.class, "com.obric.memorydata.plugin"), false);
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L26;
    L29:
        if (r7 == true) goto L43;
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).topOverlay.setOnClickListener(new $$Lambda$f$fZqL_tbXtba1Sflvf2wKVxC578g(this, r2));
        return;
    L43:
        FrameLayout r21 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).headerContainer;
        Intrinsics.checkNotNullExpressionValue(r21, "headerContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r21, View.class, "com.obric.memorydata.plugin"), false);
        return;
    L26:
        if (StringsKt.isBlank(r20) == true) goto L29;
        r7 = false;
        goto L29
    L31:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L34;
    L37:
        boolean r23 = true;
    L38:
        if (r23 == true) goto L43;
        final List<ChatListView.Companion.ChatMessage> r24 = ChatListView.f10797a.a(r2);
        if (r24.isEmpty() == true) goto L43;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "messages: " + r24, false, 4, null);
        ChatListView r25 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).chatListView;
        r25.setEnableSelect(false);
        float r26 = 14;
        r25.setBubbleRadius(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics()));
        r25.setTextSize(14.0f);
        r25.setTextLineHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 21, Resources.getSystem().getDisplayMetrics())));
        r25.setMessageSpacing(MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
        r25.setPaddingVertical(MathKt.roundToInt(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics())));
        r25.setPaddingHorizontal(MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics())));
        r25.setMaxBubbleWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 120, Resources.getSystem().getDisplayMetrics())));
        r25.setMessages(r24);
        View r27 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).topOverlay;
        View.OnClickListener r28 = new $$Lambda$f$x7Ar_OEDS_NoYyKSlynzFSXVkNw(this, r24);
    L45:
        r27.setOnClickListener(r28);
        return;
    L34:
        if (StringsKt.isBlank(r22) == true) goto L37;
        r23 = false;
        goto L38
    L18:
        if (StringsKt.isBlank(r15) == true) goto L21;
        r16 = false;
        goto L22
    L44:
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).headerContainer.setBackground(null);
        View r29 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).viewOverlay;
        Intrinsics.checkNotNullExpressionValue(r29, "viewOverlay");
        com.obric.oui.common.util.o.a(r29, false);
        LinearLayout r30 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvSourceContentContainer;
        Intrinsics.checkNotNullExpressionValue(r30, "tvSourceContentContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r30, View.class, "com.obric.memorydata.plugin"), false);
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvSourceContent.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r31 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvSourceContent;
        Intrinsics.checkNotNullExpressionValue(r31, "tvSourceContent");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r31, View.class, "com.obric.memorydata.plugin"), false);
        ImageView r32 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).imageSource;
        Intrinsics.checkNotNullExpressionValue(r32, "imageSource");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r32, View.class, "com.obric.memorydata.plugin"), true);
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowView.setChangeAlphaWhenPress(false);
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).shadowWrapper.setChangeAlphaWhenPress(false);
        ImageView r33 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).imageSource;
        Intrinsics.checkNotNullExpressionValue(r33, "imageSource");
        y.a(r33, r4, new $$Lambda$f$wNZNHlZQuED6ecVi2DuXLlSvKPU(this));
        FrameLayout r34 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).headerContainer;
        Intrinsics.checkNotNullExpressionValue(r34, "headerContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r34, View.class, "com.obric.memorydata.plugin"), true);
        r27 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).topOverlay;
        r28 = new $$Lambda$f$EoTY_fveTe7ZLSkuiSRqxEtn6E(r1, this, r4);
        goto L45
    }

    private final void a(com.obric.memorydata.memory.ui.data.a.e r25, String r26, boolean r27) {
        RunLog.INSTANCE.debug("MemoryDetailItemViewHolder", "renderWithStream: " + r25.b());     // Catch: Throwable -> L92
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "renderWithStream, detailStatus: " + r25.b().getDetailStatus(), false, 4, null);     // Catch: Throwable -> L92
        ar<String> r5 = r25.g();     // Catch: Throwable -> L92
        boolean r8 = true;
        if (r25.b().getDetailStatus() != 1) goto L11;
        if (r5 == null) goto L11;
        if (Intrinsics.areEqual(this.v, r5) == false) goto L11;
        if (this.u.get() == null) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L14;
        this.u.getAndUpdate(new $$Lambda$f$QH4SHzxUeeGo9Nq6HNfWHd7oejA(this));     // Catch: Throwable -> L92
    L14:
        int r7 = r25.b().getDetailStatus();     // Catch: Throwable -> L92
        al r9 = null;
        if (r7 != 0) goto L18;
        this.v = null;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        a(true);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        com.obric.memorydata.markdown.stream.h r10 = (com.obric.memorydata.markdown.stream.h) ZeusTransformUtils.preCheckCast(this.u.get(), com.obric.memorydata.markdown.stream.h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r10 == null) goto L107;
        com.obric.memorydata.markdown.stream.h.a(r10, r26, null, null, 6, null);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L107:
        return;
    L18:
        if (r7 != 1) goto L20;
        SessionStatus r11 = r25.f();     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r5 == null) goto L42;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r5.c(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r13 == null) goto L42;
    L44:
        if (r11 != null) goto L46;
        int r12 = -1;
    L47:
        if (r12 == (-1)) goto L87;
        if (r12 == 1) goto L87;
        if (r12 == 2) goto L68;
        if (r12 == 3) goto L64;
        if (r12 != 4) goto L53;
    L57:
        this.v = null;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r25.h(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L61;
        r8 = false;
    L61:
        if (r8 == false) goto L63;
        TextView r14 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvFailed;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        Intrinsics.checkNotNullExpressionValue(r14, "tvFailed");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        aq.a(r14, r25.h(), MapsKt.emptyMap(), com.obric.memorydata.utils.al.f13166a.b());     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
    L63:
        a(false);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L53:
        if (r12 == 5) goto L57;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
    L64:
        this.v = null;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        a(true);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        Map<String, List<String>> r15 = r25.d();     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        com.obric.memorydata.markdown.stream.h r16 = (com.obric.memorydata.markdown.stream.h) ZeusTransformUtils.preCheckCast(this.u.get(), com.obric.memorydata.markdown.stream.h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r16 == null) goto L67;
        com.obric.memorydata.markdown.stream.h.a(r16, r13, null, r15, 2, null);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
    L67:
        r25.b().setDetailStatus(2);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        r25.b().setDetail(r13);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        RunLog.INSTANCE.debug("MemoryDetailItemViewHolder", "keyInfoMap: " + r15);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        x.a((x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r25, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), false, r15, true, 2, null);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L68:
        a(true);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r5 != null) goto L71;
        com.obric.memorydata.markdown.stream.h r17 = (com.obric.memorydata.markdown.stream.h) ZeusTransformUtils.preCheckCast(this.u.get(), com.obric.memorydata.markdown.stream.h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r17 == null) goto L104;
        com.obric.memorydata.markdown.stream.h.a(r17, r13, null, null, 6, null);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L104:
        return;
    L71:
        if (Intrinsics.areEqual(this.v, r5) == true) goto L101;
        this.v = r5;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        LinearLayout r18 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot();     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        Intrinsics.checkNotNullExpressionValue(r18, "getRoot(...)");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        LifecycleCoroutineScope r19 = y.a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r19 == null) goto L75;
        al r110 = (al) ZeusTransformUtils.preCheckCast(r19, al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
    L81:
        com.obric.memorydata.markdown.stream.h r111 = (com.obric.memorydata.markdown.stream.h) ZeusTransformUtils.preCheckCast(this.u.get(), com.obric.memorydata.markdown.stream.h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r111 == null) goto L102;
        com.obric.memorydata.markdown.stream.h.a(r111, (com.obric.memorydata.markdown.stream.l) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.markdown.stream.m.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), com.obric.memorydata.markdown.stream.l.class, "com.obric.memorydata.plugin"), r110, 0, 0, 0, null, null, null, r27, 252, null);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L102:
        return;
    L75:
        com.obric.memorydata.markdown.stream.h r20 = (com.obric.memorydata.markdown.stream.h) ZeusTransformUtils.preCheckCast(this.u.get(), com.obric.memorydata.markdown.stream.h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r20 == null) goto L78;
        r9 = r20.a();     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
    L78:
        if (r9 != null) goto L80;
        return;
    L80:
        r110 = r9;
        goto L81
    L101:
        return;
    L87:
        a(true);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L46:
        r12 = b.f10856a[r11.ordinal()];     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
    L42:
        r13 = r25.e();     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        goto L44
    L20:
        if (r7 == 2) goto L26;
        if (r7 == 3) goto L25;
        if (r7 == 4) goto L25;
        this.v = null;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        LinearLayout r1 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryContainer;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        Intrinsics.checkNotNullExpressionValue(r1, "summaryContainer");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
    L24:
        com.obric.oui.common.util.o.a(r2, false);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L25:
        this.v = null;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        LinearLayout r3 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryContainer;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        Intrinsics.checkNotNullExpressionValue(r3, "summaryContainer");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        r2 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        goto L24
    L26:
        this.v = null;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        a(true);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        String r112 = r25.b().getDetail();     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r21 != null) goto L29;
    L32:
        boolean r22 = true;
    L33:
        if (r22 == false) goto L35;
        LinearLayout r4 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryContainer;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        Intrinsics.checkNotNullExpressionValue(r4, "summaryContainer");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        r2 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        goto L24
    L35:
        LinearLayout r23 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryContainer;     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        Intrinsics.checkNotNullExpressionValue(r23, "summaryContainer");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r23, View.class, "com.obric.memorydata.plugin"), true);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        com.obric.memorydata.markdown.stream.h r24 = (com.obric.memorydata.markdown.stream.h) ZeusTransformUtils.preCheckCast(this.u.get(), com.obric.memorydata.markdown.stream.h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        if (r24 == null) goto L97;
        com.obric.memorydata.markdown.stream.h.a(r24, r112, null, r25.d(), 2, null);     // Catch: Throwable -> L92 Throwable -> L92 Throwable -> L92
        return;
    L97:
        return;
    L29:
        if (r21.length() == 0) goto L32;
        r22 = false;
    L11:
        r6 = false;
    L92:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryDetailItemViewHolder", "render markdown failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(f r3, View r4) {
        com.obric.memorydata.memory.ui.data.a r5 = r3.a();
        if (ZeusTransformUtils.instanceOf(r5, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.e r6 = (com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
        r3.a(r0, r6.b());
        r3.t.invoke(new u.a.d());
        return;
    L5:
        r6 = null;
        goto L6
    }

    private static final void a(f r2, String r3, View r4) {
        SourceTextActivity.a r5 = SourceTextActivity.Companion;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r2.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        r5.a(r6, r3);
    }

    private static final void a(f r2, List r3, View r4) {
        List<ChatListView.Companion.ChatMessage> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ChatActivity.a r6 = ChatActivity.Companion;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(r2.c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "getContext(...)");
        r6.a(r7, r5);
    }

    private final void a(boolean r4) {
        MarkdownTextView r0 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryText;
        Intrinsics.checkNotNullExpressionValue(r0, "summaryText");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), r4);
        LinearLayout r3 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).failedContainer;
        Intrinsics.checkNotNullExpressionValue(r3, "failedContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), !r4);
    }

    private final boolean a(Map<String, ? extends List<String>> r8, String... r9) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        int r10 = r9.length;
        int r2 = 0;
    L4:
        if (r2 >= r10) goto L28;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r7.get(r9[r2]), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L11;
    L13:
        Iterator r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L12;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L15;
        boolean r11 = true;
    L19:
        if (r11 == true) goto L22;
        r2 = r2 + 1;
        goto L4
    L22:
        return true;
    L12:
        r11 = false;
        goto L19
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
    L28:
        return false;
    }

    private final void b(com.obric.memorydata.memory.ui.data.a.e r20) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "bindMeta", false, 4, null);
        MemoryEntity r0 = r20.b();
        TextView r1 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).titleText;
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.f.f10920a.a(r0), CharSequence.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r1);
        Integer r3 = null;
        boolean r4 = true;
        com.obric.memorydata.memory.ui.m.a(r1, null, 1, null);
        x.a r2 = x.f10883b;
        Pair<String, String> r5 = x.a(r0);
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.component1(), String.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.component2(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.utils.f r7 = com.obric.memorydata.memory.utils.f.f11537a;
        LocalDate r8 = Instant.ofEpochMilli(r0.getLastModifiedTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r8, "toLocalDate(...)");
        String r10 = r7.a(r8, true);
        StringBuilder r11 = new StringBuilder();
        if (Intrinsics.areEqual(r10, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_date_today, TypedValues.Custom.S_STRING, "memory_date_today"))) == true) goto L5;
        r11.append(r10);
        r11.append(" ");
    L5:
        r11.append(com.obric.memorydata.memory.utils.f.f11537a.a(r0.getLastModifiedTime(), false));
        String r12 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        TextView r13 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).memorySourceTv;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L8;
    L11:
        boolean r15 = true;
    L12:
        if (r15 == true) goto L15;
        r12 = r6 + " · " + r12;
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
    L15:
        r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r0.getProductType() != 11) goto L18;
    L28:
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).memorySourceIcon.setImageResource(com.obric.memorydata.memory.ui.i.f10968a.a(r0.getProductType()).b());
    L29:
        TextView r16 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tvViewSource;
        Intrinsics.checkNotNullExpressionValue(r16, "tvViewSource");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"), false);
        return;
    L18:
        if (com.obric.memorydata.database.model.e.f9611a.a(r0.getProductType()) == true) goto L28;
        com.obric.memorydata.memory.ui.list.af r17 = com.obric.memorydata.memory.ui.list.ae.f11174a.a(r0.getProductType(), MemorySourceIconScene.DETAIL);
        com.obric.memorydata.utils.icon.b r18 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r19 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r19, "getContext(...)");
        AppCompatImageView r21 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).memorySourceIcon;
        Intrinsics.checkNotNullExpressionValue(r21, "memorySourceIcon");
        ImageView r22 = (ImageView) ZeusTransformUtils.preCheckCast(r21, ImageView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L22;
        String r110 = r17.b();
    L23:
        if (r17 == null) goto L25;
        r3 = Integer.valueOf(r17.a());
    L25:
        if (r17 == null) goto L27;
        r4 = r17.c();
    L27:
        com.obric.memorydata.utils.icon.b.a(r18, r19, r22, r9, null, 0, null, null, r110, r3, r4, 120, null);
        goto L29
    L22:
        r110 = null;
        goto L23
    L8:
        if (r14.length() == 0) goto L11;
        r15 = false;
        goto L12
    }

    private static final void b(f r0, View r1) {
        r0.t.invoke(new u.a.b());
    }

    private final void c(com.obric.memorydata.memory.ui.data.a.e r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "bindSummary", false, 4, null);
        MemoryEntity r0 = r11.b();
        String r1 = f10855a.a(r0);
        if (ZeusTransformUtils.instanceOf(r0, CollectContentMemoryEntity.class) == false) goto L7;
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tagsLinearLayout.removeAllViews();
    L5:
        FlowLayout r2 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tagsLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r2, "tagsLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), false);
    L23:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L25;
        boolean r3 = true;
    L26:
        if (r3 == true) goto L28;
    L31:
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryText.setTextSize(2, 14.0f);
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryText.setLineHeight(2, 22.0f);
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryText.setMarkdownWidth((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels - (MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())) * 2)) - (MathKt.roundToInt(TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics())) * 2));
        a(r11, r1, true);
        return;
    L28:
        if (r11.b().getDetailStatus() != 0) goto L31;
        LinearLayout r10 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).summaryContainer;
        Intrinsics.checkNotNullExpressionValue(r10, "summaryContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), false);
        return;
    L25:
        r3 = false;
        goto L26
    L7:
        if (ZeusTransformUtils.instanceOf(r0, CommonTextMemoryEntity.class) == false) goto L23;
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTagList(), Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L5;
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tagsLinearLayout.removeAllViews();
        FlowLayout r6 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tagsLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r6, "tagsLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), false);
        List<String> r7 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTagList();
        if (r7 == null) goto L23;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r8.hasNext() == false) goto L23;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        View r12 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.article_tag_layout, "layout", "article_tag_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tagsLinearLayout, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(ZeusTransformUtils.mapRes(R.id.tag_text, OaidModel.KEY_ID, "tag_text")), TextView.class, "com.obric.memorydata.plugin");
        r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r13);
        com.obric.memorydata.memory.ui.m.a(r13, null, 1, null);
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).tagsLinearLayout.addView(r12);
        goto L20
    L11:
        if (r4.isEmpty() == true) goto L14;
        r5 = false;
        goto L15
    }

    private static final void c(f r0, View r1) {
        r0.t.invoke(new u.a.c());
    }

    private static final void d(f r0, View r1) {
        r0.t.invoke(new u.a.C0555a());
    }

    private static final void e(f r0, View r1) {
        r0.t.invoke(new u.a.e());
    }

    /* JADX INFO: renamed from: lambda$-EoTY_fveTe7ZLSkuiSRqxEtn6E, reason: not valid java name */
    public static /* synthetic */ void m849lambda$EoTY_fveTe7ZLSkuiSRqxEtn6E(MemoryEntity r0, f r1, FileEntity r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$GFsDtQ1VrIWXCbH03SpqkzmRH38(f r0, View r1) {
        d(r0, r1);
    }

    public static /* synthetic */ com.obric.memorydata.markdown.stream.h lambda$GaExozV89ERwugemQyPPsDvmFlQ(com.obric.memorydata.markdown.stream.h r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$NMcU4NUkvj5eKjYebkrVcc4NzJE(f r0, View r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void lambda$PpMGfgAqScWlcV1WW6pQxE9N0nw(f r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ com.obric.memorydata.markdown.stream.h lambda$QH4SHzxUeeGo9Nq6HNfWHd7oejA(f r0, com.obric.memorydata.markdown.stream.h r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$VILD8cVKfPee9cMweapCGKDI9Io(f r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$V_BkY6mlDVRfi8YMo_6epM9ojBk(f r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$aVhti7RgGYlxaoDX8C3W6lu8oXw(f r0, View r1) {
        e(r0, r1);
    }

    public static /* synthetic */ void lambda$fZqL_tbXtba1Sflvf2wKVxC578g(f r0, String r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$wNZNHlZQuED6ecVi2DuXLlSvKPU(f r0, boolean r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$x7Ar_OEDS_NoYyKSlynzFSXVkNw(f r0, List r1, View r2) {
        a(r0, r1, r2);
    }

    public final List<String> a(Map<String, ? extends List<String>> r19, Map<String, ? extends List<String>> r20) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "map1");
        Intrinsics.checkNotNullParameter(r2, "map2");
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Set r4 = SetsKt.minus(r0.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(r2.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        r3.add("Map1 包含 Map2 没有的键：" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L5:
        Set r5 = SetsKt.minus(r2.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(r0.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        r3.add("Map2 包含 Map1 没有的键：" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    L8:
        Iterator r6 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r0.keySet(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r2.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L18;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        Object r8 = r0.get(r7);
        Intrinsics.checkNotNull(r8);
        List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        Object r10 = r2.get(r7);
        Intrinsics.checkNotNull(r10);
        List r11 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        if (r9.size() != r11.size()) goto L13;
        if (Intrinsics.areEqual(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        StringBuilder r12 = new StringBuilder().append("键 '").append(r7).append("' 对应的List内容不同（顺序无关）：Map1=[").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append("]，Map2=[").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append(']');
    L14:
        r3.add(r12.toString());
        goto L10
    L13:
        r12 = new StringBuilder().append("键 '").append(r7).append("' 对应的List大小不同：Map1 大小=").append(r9.size()).append("，Map2 大小=").append(r11.size());
        goto L14
    L18:
        return r3;
    }

    @Override // com.obric.memorydata.memory.ui.detail.x
    public void a(com.obric.memorydata.memory.ui.data.a r21, boolean r22, Map<String, ? extends List<String>> r23, boolean r24) {
        Map<String, ? extends List<String>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "item");
        Intrinsics.checkNotNullParameter(r9, "keyInfoMap");
        if (ZeusTransformUtils.instanceOf(r21, com.obric.memorydata.memory.ui.data.a.e.class) == true) goto L5;
        return;
    L5:
        if (((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getType() != (-401)) goto L8;
        return;
    L8:
        if (r22 == false) goto L10;
        ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).a(true);
    L10:
        Map<String, List<String>> r11 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).d();
        ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).a(r9);
        x.a r0 = x.f10883b;
        String r12 = (String) ZeusTransformUtils.preCheckCast(x.a(((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b()).component2(), String.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getSourceLinkType() == null) goto L13;
        boolean r2 = true;
    L14:
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getDetailStatus() == 1) goto L17;
    L18:
        if (r2 == false) goto L21;
        r3.add(AILabCheckPermissionTask.KEY_SOURCE);
    L21:
        if (((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).c() == false) goto L24;
        r3.add("calendar");
    L24:
        if (a(r9, new String[]{MemoryKeyInfoEntity.KEY_PHONE}) == false) goto L27;
        r3.add(MemoryKeyInfoEntity.KEY_PHONE);
    L27:
        if (a(r9, new String[]{MemoryKeyInfoEntity.KEY_ADDRESS, "location"}) == false) goto L30;
        r3.add(MemoryKeyInfoEntity.KEY_ADDRESS);
    L30:
        if (a(r9, new String[]{"url"}) == false) goto L33;
        r3.add("url");
    L33:
        if (r3.isEmpty() == true) goto L35;
        boolean r14 = !this.w.isEmpty();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.w.keySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L42:
        if (r6.hasNext() == false) goto L46;
        Object r7 = r6.next();
        if ((!r3.contains((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"))) == false) goto L42;
        r5.add(r7);
        goto L42
    L46:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L48:
        if (r8.hasNext() == false) goto L56;
        View r10 = (View) ZeusTransformUtils.preCheckCast(this.w.remove((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")), View.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L48;
        if (r24 == false) goto L54;
        if (r14 == false) goto L54;
        FlowLayout.a(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout, r10, null, 2, null);
    L54:
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.removeView(r10);
        goto L48
    L56:
        List<? extends Pair<? extends View, Integer>> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(x, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L58:
        if (r17.hasNext() == false) goto L68;
        Object r18 = r17.next();
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin");
        if (r3.contains(r19) == true) goto L62;
    L64:
        boolean r20 = false;
    L65:
        if (r20 == false) goto L58;
        r16.add(r18);
        goto L58
    L62:
        if (this.w.containsKey(r19) == true) goto L64;
        r20 = true;
        goto L65
    L68:
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r111 = 0;
    L70:
        if (r110.hasNext() == false) goto L78;
        Object r25 = r110.next();
        int r112 = r111 + 1;
        if (r111 >= 0) goto L74;
        CollectionsKt.throwIndexOverflow();
    L74:
        String r26 = (String) ZeusTransformUtils.preCheckCast(r25, String.class, "com.obric.memorydata.plugin");
        String r27 = a(r26, r12);
        String r28 = r12;
        List<? extends Pair<? extends View, Integer>> r113 = r13;
        View r29 = a(this, r27, r26, 0, 4, null);
        this.w.put(r26, r29);
        if (r14 == false) goto L77;
        r111 = a(r26) + r111;
    L77:
        r113.add(TuplesKt.to(r29, Integer.valueOf(r111)));
        r13 = r113;
        r111 = r112;
        r12 = r28;
        goto L70
    L78:
        List<? extends Pair<? extends View, Integer>> r114 = r13;
        if (r14 == true) goto L90;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r114, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L90;
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L84:
        if (r30.hasNext() == false) goto L86;
        Pair r31 = (Pair) ZeusTransformUtils.preCheckCast(r30.next(), Pair.class, "com.obric.memorydata.plugin");
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.addView((View) ZeusTransformUtils.preCheckCast(r31.component1(), View.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r31.component2(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L84
    L86:
        if (r24 == false) goto L88;
        FlowLayout.a(((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout, null, 1, null);
    L100:
        List<String> r32 = a(r11, r9);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDetailItemViewHolder", "bindCapsule differences: " + r32, false, 4, null);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r32, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L122;
        c((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin"));
        return;
    L122:
        return;
    L88:
        FlowLayout r33 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r33, "capsuleLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r33, View.class, "com.obric.memorydata.plugin"), true);
    L90:
        if (r14 == true) goto L92;
    L99:
        FlowLayout r34 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r34, "capsuleLinearLayout");
        View r35 = (View) ZeusTransformUtils.preCheckCast(r34, View.class, "com.obric.memorydata.plugin");
        r1 = true;
    L39:
        com.obric.oui.common.util.o.a(r35, r1);
        goto L100
    L92:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r114, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L99;
        if (r24 == false) goto L95;
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.a(r114);
        goto L99
    L95:
        Iterator r36 = ((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L97:
        if (r36.hasNext() == false) goto L99;
        Pair r37 = (Pair) ZeusTransformUtils.preCheckCast(r36.next(), Pair.class, "com.obric.memorydata.plugin");
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.addView((View) ZeusTransformUtils.preCheckCast(r37.component1(), View.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r37.component2(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L97
    L35:
        if ((!this.w.isEmpty()) == false) goto L38;
        if (r24 == false) goto L38;
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.b(new $$Lambda$f$VILD8cVKfPee9cMweapCGKDI9Io(this));
    L38:
        this.w.clear();
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.removeAllViews();
        FlowLayout r38 = ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r38, "capsuleLinearLayout");
        r35 = (View) ZeusTransformUtils.preCheckCast(r38, View.class, "com.obric.memorydata.plugin");
        goto L39
    L17:
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new SessionStatus[]{SessionStatus.INITIALIZED, SessionStatus.STREAMING}), Iterable.class, "com.obric.memorydata.plugin"), ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).f()) == true) goto L100;
    L13:
        r2 = false;
        goto L14
    }

    public final void b() {
        this.w.clear();
        ((ItemMemoryDetailGlobalBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailGlobalBinding.class, "com.obric.memorydata.plugin")).capsuleLinearLayout.removeAllViews();
        this.v = null;
        this.u.getAndUpdate($$Lambda$f$GaExozV89ERwugemQyPPsDvmFlQ.INSTANCE);
    }

    @Override // com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryItem");
        super.b(r10);
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L5;
        com.obric.memorydata.memory.ui.data.a.e r11 = (com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin");
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        a(r11);
        b(r11);
        x.a((x) ZeusTransformUtils.preCheckCast(this, x.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), r11.c(), r11.d(), false, 8, null);
        c(r11);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
