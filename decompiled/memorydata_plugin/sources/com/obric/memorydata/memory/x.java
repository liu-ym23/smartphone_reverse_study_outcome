package com.obric.memorydata.memory;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.island.BatchMemoryIslandKind;
import com.obric.memorydata.memory.island.IslandRouter;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.memory.State;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eJD\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0005J/\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H#0(¢\u0006\u0002\u0010)JN\u0010*\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ \u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u000e\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u001dJ\u0012\u00102\u001a\u00020\u0005*\b\u0012\u0004\u0012\u0002030\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/memorydata/memory/MemoryPublisher;", "", "<init>", "()V", "TAG", "", "assistantCallback", "Lcom/obric/memorydata/sdk/memory/IMemoryCallback;", "assistantCallbackDeathRecipient", "Landroid/os/IBinder$DeathRecipient;", "batchSession", "Ljava/lang/ThreadLocal;", "Lcom/obric/memorydata/memory/MemoryPublisher$BatchMemorySession;", "unlinkDeathRecipient", "", "callback", "deathRecipient", "registerMemoryCallback", "unregisterMemoryCallback", "toastForbiddenMemory", "toastNetworkNotAvailable", "showMemory", OaidModel.KEY_ID, "state", "Lcom/obric/memorydata/sdk/memory/State;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "needEffect", "", "calendars", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "showMemoryCancelled", "collectBatchMemoryResult", ExifInterface.GPS_DIRECTION_TRUE, LBSLightLocationTraceLogger.TOTAL, "", "typeName", "block", "Lkotlin/Function0;", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "showMemoryList", "entities", "oldEntities", "showBatchMemorySummary", "summary", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandSummary;", "onDialogueMemoryEnableChanged", "enable", "toLogString", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandItem;", "BatchMemorySession", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f11587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.obric.memorydata.sdk.memory.a f11588b;
    private static IBinder.DeathRecipient c;
    private static final ThreadLocal<a> d = null;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J8\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aJ\u0006\u0010\u001b\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\f\u0010\u001e\u001a\u00020\u001f*\u00020\u000bH\u0002J\u0012\u0010 \u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002J\u000e\u0010 \u001a\u00020\u0005*\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/MemoryPublisher$BatchMemorySession;", "", LBSLightLocationTraceLogger.TOTAL, "", "typeName", "", "<init>", "(ILjava/lang/String;)V", OaidModel.KEY_ID, "entities", "", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntities", "resultItems", "Lcom/obric/memorydata/memory/MemoryPublisher$BatchMemorySession$BatchResultItem;", "calendars", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "failureCount", "collect", "", "itemId", "state", "Lcom/obric/memorydata/sdk/memory/State;", "entity", "oldEntity", "itemCalendars", "", "publish", "buildSummary", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandSummary;", "batchKind", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;", "toLogString", "productTypeName", "productType", "BatchResultItem", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11590b;
        private final String c;
        private final List<MemoryEntity> d;
        private final List<MemoryEntity> e;
        private final List<C0620a> f;
        private final List<PendingMemoryCalendar> g;
        private int h;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.x$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/MemoryPublisher$BatchMemorySession$BatchResultItem;", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "<init>", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;)V", "getEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getOldEntity", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private static final class C0620a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final MemoryEntity f11591a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final MemoryEntity f11592b;

            public C0620a(MemoryEntity r2, MemoryEntity r3) {
                Intrinsics.checkNotNullParameter(r2, "entity");
                this.f11591a = r2;
                this.f11592b = r3;
            }

            public final MemoryEntity a() {
                return this.f11591a;
            }

            public final MemoryEntity b() {
                return this.f11592b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0620a.class) == true) goto L8;
                return false;
            L8:
                C0620a r6 = (C0620a) ZeusTransformUtils.preCheckCast(r5, C0620a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f11591a, r6.f11591a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f11592b, r6.f11592b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.f11591a.hashCode() * 31;
                MemoryEntity r1 = this.f11592b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "BatchResultItem(entity=" + this.f11591a + ", oldEntity=" + this.f11592b + ')';
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11593a = null;

            static {
                int[] r0 = new int[State.values().length];
                r0[State.SUCCESS_NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[State.SUCCESS_UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[State.FAILURE_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f11593a = r0;
            }
        }

        public a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "typeName");
            this.f11589a = r2;
            this.f11590b = r3;
            String r4 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
            this.c = r4;
            this.d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.g = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        private final BatchMemoryIslandKind a(MemoryEntity r2) {
            if (r2.getType() != (-401)) goto L6;
        L18:
            return BatchMemoryIslandKind.SEMANTIC;
        L6:
            if (ZeusTransformUtils.instanceOf(r2, InfoCommonMemoryEntity.class) == true) goto L18;
            if (ZeusTransformUtils.instanceOf(r2, InfoDocumentsMemoryEntity.class) == true) goto L18;
            if (ZeusTransformUtils.instanceOf(r2, InfoAddressMemoryEntity.class) == true) goto L18;
            if (ZeusTransformUtils.instanceOf(r2, InfoAnniversaryMemoryEntity.class) == true) goto L18;
            if (ZeusTransformUtils.instanceOf(r2, InfoRelationshipMemoryEntity.class) == true) goto L18;
            return BatchMemoryIslandKind.EPISODIC;
        }

        private static final CharSequence a(a r1, MemoryEntity r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r1.b(r2), CharSequence.class, "com.obric.memorydata.plugin");
        }

        private final String a(int r3) {
            if (r3 == 8) goto L13;
            switch(r3) {
                case 13: goto L12;
                case 14: goto L11;
                case 15: goto L10;
                case 16: goto L9;
                case 17: goto L8;
                case 18: goto L7;
                case 19: goto L6;
                default: goto L16;
            };
        L6:
            StringBuilder r2 = new StringBuilder();
            String r1 = "gallery_screenshot(";
        L15:
            return r2.append(r1).append(r3).append(')').toString();
        L7:
            r2 = new StringBuilder();
            r1 = "camera_postview(";
            goto L15
        L8:
            r2 = new StringBuilder();
            r1 = "camera_viewfinder(";
            goto L15
        L9:
            r2 = new StringBuilder();
            r1 = "gallery_document(";
            goto L15
        L10:
            r2 = new StringBuilder();
            r1 = "gallery_single(";
            goto L15
        L11:
            r2 = new StringBuilder();
            r1 = "share(";
            goto L15
        L12:
            r2 = new StringBuilder();
            r1 = "screenshot_scroll(";
            goto L15
        L16:
            return String.valueOf(r3);
        L13:
            r2 = new StringBuilder();
            r1 = "screenshot(";
            goto L15
        }

        private final String a(List<? extends MemoryEntity> r12) {
            return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, new $$Lambda$x$a$Q875bDzY9sZagrHEEgA0Ccnc0Ww(this), 25, null);
        }

        private final com.obric.memorydata.memory.island.c b() {
            String r1 = this.c;
            int r2 = this.f11589a;
            int r3 = this.h;
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r5 = r0.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            C0620a r6 = (C0620a) ZeusTransformUtils.preCheckCast(r5.next(), C0620a.class, "com.obric.memorydata.plugin");
            r4.add(new com.obric.memorydata.memory.island.b(a(r6.a()), r6.a(), r6.b()));
            goto L4
        L6:
            List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin");
            HashSet r8 = new HashSet();
            ArrayList r9 = new ArrayList();
            Iterator r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L13;
            Object r12 = r11.next();
            if (r8.add(Long.valueOf(((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r12, PendingMemoryCalendar.class, "com.obric.memorydata.plugin")).getId())) == false) goto L8;
            r9.add(r12);
            goto L8
        L13:
            return new com.obric.memorydata.memory.island.c(r1, r2, r3, r7, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"));
        }

        private final String b(MemoryEntity r3) {
            if (r3 != null) goto L6;
            return "null";
        L6:
            return "{id=" + r3.getId() + ", uuid=" + r3.getUuid() + ", type=" + r3.getType() + ", productType=" + a(r3.getProductType()) + '}';
        }

        public static /* synthetic */ CharSequence lambda$Q875bDzY9sZagrHEEgA0Ccnc0Ww(a r0, MemoryEntity r1) {
            return a(r0, r1);
        }

        public final void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "publishBatchMemoryResult batchType=" + this.f11590b + ", total=" + this.f11589a + ", success=" + this.d.size() + ", failure=" + this.h + ", entities=" + a(this.d) + ", oldEntities=" + a(this.e), false, 4, null);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.d, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
            x.f11587a.a(b(), State.SUCCESS_NEW, false);
            return;
        L5:
            x.a(x.f11587a, this.c, State.FAILURE_ERROR, null, null, false, null, 32, null);
        }

        public final void a(String r9, State r10, MemoryEntity r11, MemoryEntity r12, List<PendingMemoryCalendar> r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "itemId");
            Intrinsics.checkNotNullParameter(r10, "state");
            Intrinsics.checkNotNullParameter(r14, "itemCalendars");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "collectBatchMemoryResult batchType=" + this.f11590b + ", item=" + r9 + ", state=" + r10 + ", entity=" + b(r11) + ", old=" + b(r12) + ", total=" + this.f11589a, false, 4, null);
            int r15 = b.f11593a[r10.ordinal()];
            if (r15 != 1) goto L5;
        L10:
            if (r11 == null) goto L12;
            this.d.add(r11);
        L12:
            if (r12 == null) goto L14;
            this.e.add(r12);
        L14:
            if (r11 == null) goto L16;
            this.f.add(new C0620a(r11, r12));
        L16:
            this.g.addAll((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            if (r15 == 2) goto L10;
            if (r15 != 3) goto L19;
            this.h++;
            return;
        }
    }

    static {
        f11587a = new x();
        d = new ThreadLocal();
    }

    private x() {
    }

    private final String a(List<com.obric.memorydata.memory.island.b> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r2 = r9.next();
        BatchMemoryIslandKind r3 = ((com.obric.memorydata.memory.island.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.island.b.class, "com.obric.memorydata.plugin")).a();
        Object r4 = r1.get(r3);
        if (r4 != null) goto L8;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r1.put(r3, r4);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).add(r2);
        goto L4
    L9:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r1.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        Object r11 = r5.next();
        r10.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r11, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.valueOf(((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r11, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")).size()));
        goto L11
    L13:
        StringBuilder r12 = new StringBuilder().append("{size=").append(r6.size()).append(", grouped=").append(r10).append(", first=");
        com.obric.memorydata.memory.island.b r13 = (com.obric.memorydata.memory.island.b) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r6), com.obric.memorydata.memory.island.b.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L18;
        MemoryEntity r14 = r13.b();
        if (r14 == null) goto L18;
        String r15 = r14.getId();
    L20:
        return r12.append(r15).append('}').toString();
    L18:
        r15 = null;
        goto L20
    }

    public static /* synthetic */ void a(x r1, com.obric.memorydata.sdk.memory.a r2, IBinder.DeathRecipient r3, int r4, Object r5) {
        com.obric.memorydata.sdk.memory.a r6 = (com.obric.memorydata.sdk.memory.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.sdk.memory.a.class, "com.obric.memorydata.plugin");
        IBinder.DeathRecipient r7 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r1.a(r6, r7);
    }

    public static /* synthetic */ void a(x r7, String r8, State r9, MemoryEntity r10, MemoryEntity r11, boolean r12, List r13, int r14, Object r15) {
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

    private final void b(com.obric.memorydata.sdk.memory.a r7, IBinder.DeathRecipient r8) {
        com.obric.memorydata.sdk.memory.a r6 = (com.obric.memorydata.sdk.memory.a) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.sdk.memory.a.class, "com.obric.memorydata.plugin");
        IBinder.DeathRecipient r9 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r8, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L13;
        if (r9 == null) goto L14;
        r6.asBinder().unlinkToDeath(r9, 0);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "unlink memory callback death recipient failed: " + e.getMessage(), null, 4, null);
        return;
    L14:
        return;
    }

    private static final Unit c() {
        ba.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), at.a(ZeusTransformUtils.mapRes(R.string.memory_screenshot_forbidden, TypedValues.Custom.S_STRING, "memory_screenshot_forbidden")), 0, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit d() {
        ba.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), at.a(ZeusTransformUtils.mapRes(R.string.memory_net_not_available_toast, TypedValues.Custom.S_STRING, "memory_net_not_available_toast")), 0, 4, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$MKeH7xc69rlhiuIQuQsWz67noOU() {
        return c();
    }

    /* JADX INFO: renamed from: lambda$VnV-67V9bp1_NtR8Lu1ItPjPNOs, reason: not valid java name */
    public static /* synthetic */ Unit m1006lambda$VnV67V9bp1_NtR8Lu1ItPjPNOs() {
        return d();
    }

    public final <T> T a(int r2, String r3, Function0<? extends T> r4) {
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "typeName");
        Intrinsics.checkNotNullParameter(r1, "block");
        if (r2 <= 1) goto L15;
        ThreadLocal<a> r5 = d;
        if (r5.get() != null) goto L15;
        a r0 = new a(r2, r3);
        r5.set(r0);
        T r6 = (T) r1.invoke();
        r5.remove();
        r0.a();
        return r6;
    L11:
        th = move-exception;
        d.remove();
        r0.a();
        throw th;
    L15:
        return (T) r1.invoke();
    }

    public final void a() {
        com.obric.memorydata.utils.j.a($$Lambda$x$MKeH7xc69rlhiuIQuQsWz67noOU.INSTANCE);
    }

    public final void a(com.obric.memorydata.memory.island.c r10, State r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "summary");
        Intrinsics.checkNotNullParameter(r11, "state");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "showBatchMemorySummary " + r11 + ", total=" + r10.b() + ", success=" + r10.f() + ", failure=" + r10.c() + ", items=" + a(r10.d()), false, 4, null);
        IslandRouter.f10185a.a(r10, r11.ordinal(), r12);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "showBatchMemorySummary error: " + e.getMessage(), null, 4, null);
    }

    public final synchronized void a(com.obric.memorydata.sdk.memory.a r4) {
        monitor-enter(this);
        com.obric.memorydata.sdk.memory.a r5 = (com.obric.memorydata.sdk.memory.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.sdk.memory.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r5, "callback");     // Catch: Throwable -> L12
        com.obric.memorydata.sdk.memory.a r0 = f11588b;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        IBinder r1 = r0.asBinder();     // Catch: Throwable -> L12
    L8:
        if (r1 != r5.asBinder()) goto L10;
        b(r5, c);     // Catch: Throwable -> L12
        f11588b = null;     // Catch: Throwable -> L12
        c = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        r1 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(com.obric.memorydata.sdk.memory.a r3, IBinder.DeathRecipient r4) {
        monitor-enter(this);
        com.obric.memorydata.sdk.memory.a r5 = (com.obric.memorydata.sdk.memory.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.sdk.memory.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        IBinder.DeathRecipient r6 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        b(f11588b, c);     // Catch: Throwable -> L6
        f11588b = r5;     // Catch: Throwable -> L6
        c = r6;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, OaidModel.KEY_ID);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "showMemoryCancelled id=" + r7, false, 4, null);
        IslandRouter.f10185a.a(r7);
    }

    public final void a(String r9, State r10, MemoryEntity r11, MemoryEntity r12, boolean r13, List<PendingMemoryCalendar> r14) {
        List<PendingMemoryCalendar> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r7, "calendars");
        a r1 = (a) ZeusTransformUtils.preCheckCast(d.get(), a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.a(r9, r10, r11, r12, r7);
        return;
    L6:
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("showMemory ").append(r10).append(", new:");
        Integer r15 = null;
        if (r11 == null) goto L9;
        Integer r3 = Integer.valueOf(r11.getType());
    L10:
        StringBuilder r16 = r8.append(r3).append(" old:");
        if (r12 == null) goto L13;
        r15 = Integer.valueOf(r12.getType());
    L13:
        IRunLog.a.a(r2, "MemoryPublisher", r16.append(r15).toString(), false, 4, null);
        IslandRouter.f10185a.a(r9, r10.ordinal(), r11, r12, r13, r7);     // Catch: RemoteException -> L16
        return;
    L16:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "showMemory error: " + e.getMessage(), null, 4, null);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void a(boolean r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "onDialogueMemoryEnableChanged " + r9, false, 4, null);
        com.obric.memorydata.sdk.memory.a r8 = f11588b;     // Catch: RemoteException -> L7
        if (r8 == null) goto L12;
        r8.a(r9);     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryPublisher", "onDialogueMemoryEnableChanged error: " + e.getMessage(), null, 4, null);
    }

    public final void b() {
        com.obric.memorydata.utils.j.a($$Lambda$x$VnV67V9bp1_NtR8Lu1ItPjPNOs.INSTANCE);
    }
}
