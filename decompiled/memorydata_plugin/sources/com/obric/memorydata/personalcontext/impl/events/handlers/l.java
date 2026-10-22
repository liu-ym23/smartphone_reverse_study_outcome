package com.obric.memorydata.personalcontext.impl.events.handlers;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/VideoFrameEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "firstFrameChecker", "Lkotlin/Function1;", "Lcom/obric/memorydata/database/entity/RawVideoFrameEntity;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "suppressor", "Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "dispatchIfFirstFrame", TypedValues.AttributesType.S_FRAME, "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<hr, Boolean> f12222b;
    private final com.obric.memorydata.personalcontext.impl.events.b.a c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/VideoFrameEntityEventHandler$Companion;", "", "<init>", "()V", "isFirstFrame", "", TypedValues.AttributesType.S_FRAME, "Lcom/obric/memorydata/database/entity/RawVideoFrameEntity;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final boolean a(hr r9) {
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getVideoFrameRawDbDao().queryByPhotoEntityDbId(r9.f()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
            if (r8.hasNext() == true) goto L5;
            Object r10 = null;
        L15:
            hr r11 = (hr) ZeusTransformUtils.preCheckCast(r10, hr.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L18;
            return false;
        L18:
            if (r11.getId() != r9.getId()) goto L24;
            return true;
        L24:
            return false;
        L5:
            Object r0 = r8.next();
            if (r8.hasNext() == true) goto L8;
        L7:
            r10 = r0;
            goto L15
        L8:
            long r2 = ((hr) ZeusTransformUtils.preCheckCast(r0, hr.class, "com.obric.memorydata.plugin")).c();
        L9:
            Object r4 = r8.next();
            long r5 = ((hr) ZeusTransformUtils.preCheckCast(r4, hr.class, "com.obric.memorydata.plugin")).c();
            if (r2 <= r5) goto L13;
            r0 = r4;
            r2 = r5;
        L13:
            if (r8.hasNext() == true) goto L9;
            goto L7
        }

        public static final /* synthetic */ boolean a(a r0, hr r1) {
            return r0.a(r1);
        }
    }

    static {
        f12221a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public l(Function1<? super hr, Boolean> r4) {
        Function1<hr, Boolean> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "firstFrameChecker");
        this.f12222b = r5;
        this.c = new com.obric.memorydata.personalcontext.impl.events.b.a(5, 1000);
    }

    public /* synthetic */ l(Function1 r2, int r3, DefaultConstructorMarker r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (Function1) ZeusTransformUtils.preCheckCast(new VideoFrameEntityEventHandler$1(f12221a), Function1.class, "com.obric.memorydata.plugin");
    L5:
        this(r5);
    }

    private final List<com.obric.memorydata.personalcontext.impl.events.a> a(hr r5) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f12222b.invoke(r5), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
        if (this.c.a() == false) goto L10;
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(EventNames.PHOTO_CREATED, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r5.f())), TuplesKt.to("raw_table", "RawPhotoEntity"), TuplesKt.to("operation", "insert")})));
    L10:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r3, Object r5) {
        Intrinsics.checkNotNullParameter(r5, "raw");
        if (ZeusTransformUtils.instanceOf(r5, hr.class) == false) goto L5;
        hr r4 = (hr) ZeusTransformUtils.preCheckCast(r5, hr.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.b(r4.getCreateTime()) == true) goto L23;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == true) goto L23;
        return a(r4);
    L14:
        if (StringsKt.isBlank(r6) == true) goto L17;
        r7 = false;
    L23:
        return CollectionsKt.emptyList();
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r3, Object r5, Object r6) {
        Intrinsics.checkNotNullParameter(r6, "raw");
        String r4 = null;
        if (ZeusTransformUtils.instanceOf(r6, hr.class) == false) goto L5;
        hr r7 = (hr) ZeusTransformUtils.preCheckCast(r6, hr.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (ZeusTransformUtils.instanceOf(r5, hr.class) == false) goto L12;
        hr r8 = (hr) ZeusTransformUtils.preCheckCast(r5, hr.class, "com.obric.memorydata.plugin");
    L13:
        if (r8 == null) goto L15;
        r4 = r8.d();
    L15:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r10 = false;
        if (r9 != null) goto L18;
    L21:
        boolean r11 = true;
    L22:
        if (r11 == false) goto L37;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L26;
    L27:
        r10 = true;
    L28:
        if (r10 == true) goto L37;
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.b(r7.getCreateTime()) == false) goto L35;
        return CollectionsKt.emptyList();
    L35:
        return a(r7);
    L26:
        if (StringsKt.isBlank(r12) == false) goto L28;
    L37:
        return CollectionsKt.emptyList();
    L18:
        if (StringsKt.isBlank(r9) == true) goto L21;
        r11 = false;
        goto L22
    L12:
        r8 = null;
        goto L13
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r1, Object r3) {
        return CollectionsKt.emptyList();
    }
}
