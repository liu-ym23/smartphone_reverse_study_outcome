package com.obric.memorydata.realtimecontext.cache;

import android.content.ComponentName;
import android.graphics.Bitmap;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.realtimecontext.screen.ScreenViewTree;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rJ\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0012J\u0016\u0010\b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0006J\u001e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00062\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0012J\u001c\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J4\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00122\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0006\u0010'\u001a\u00020\u001cJ\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u001cJ\u0006\u0010*\u001a\u00020\u001cJ\u0006\u0010+\u001a\u00020\u001cR'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\tR-\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00140\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\t¨\u0006,"}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/ScreenCache;", "", "<init>", "()V", "bitmapCache", "Lcom/obric/memorydata/realtimecontext/cache/SafeCache;", "Landroid/graphics/Bitmap;", "Lcom/obric/memorydata/realtimecontext/cache/BitmapCache;", "getBitmapCache", "()Lcom/obric/memorydata/realtimecontext/cache/SafeCache;", "bitmapCache$delegate", "Lkotlin/Lazy;", "viewTreeCache", "Lcom/obric/memorydata/realtimecontext/screen/ScreenViewTree;", "Lcom/obric/memorydata/realtimecontext/cache/ViewTreeCache;", "getViewTreeCache", "viewTreeCache$delegate", "donationCache", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/memorydata/realtimecontext/cache/DonationCache;", "getDonationCache", "donationCache$delegate", "Lcom/obric/memorydata/realtimecontext/cache/CacheResult;", "componentName", "Landroid/content/ComponentName;", "newScreenViewTree", "setViewTreeCache", "", "screenViewTree", "newMetaValues", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "newBitmap", "setBitmapCache", "bitmap", "newInAppEntities", "setDonationCache", "inAppEntities", "newAppEntity", "clearViewTreeCache", "clearBitmapCache", "clearDonationCache", "clearCaching", "clear", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f12458b = null;
    private static final Lazy c = null;
    private static final Lazy d = null;

    static {
        f12457a = new f();
        f12458b = LazyKt.lazy($$Lambda$f$xdC4gxzJAa14bzrUEmJBqq371Pw.INSTANCE);
        c = LazyKt.lazy($$Lambda$f$c3RrfT0O0fDN6kAu8IUh2U64dNs.INSTANCE);
        d = LazyKt.lazy($$Lambda$f$81DuQmdDQbzG2em9M6AXKaR3Jo.INSTANCE);
    }

    private f() {
    }

    private final e<Bitmap, b> f() {
        return (e) ZeusTransformUtils.preCheckCast(f12458b.getValue(), e.class, "com.obric.memorydata.plugin");
    }

    private final e<ScreenViewTree, g> g() {
        return (e) ZeusTransformUtils.preCheckCast(c.getValue(), e.class, "com.obric.memorydata.plugin");
    }

    private final e<List<AppEntity>, d> h() {
        return (e) ZeusTransformUtils.preCheckCast(d.getValue(), e.class, "com.obric.memorydata.plugin");
    }

    private static final e i() {
        return new e((a) ZeusTransformUtils.preCheckCast(b.f12449a.a(), a.class, "com.obric.memorydata.plugin"));
    }

    private static final e j() {
        return new e((a) ZeusTransformUtils.preCheckCast(g.f12459a.a(), a.class, "com.obric.memorydata.plugin"));
    }

    private static final e k() {
        return new e((a) ZeusTransformUtils.preCheckCast(d.f12453a.a(), a.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lambda$81DuQmdDQbzG2em9M6AXKaR-3Jo, reason: not valid java name */
    public static /* synthetic */ e m1108lambda$81DuQmdDQbzG2em9M6AXKaR3Jo() {
        return k();
    }

    public static /* synthetic */ e lambda$c3RrfT0O0fDN6kAu8IUh2U64dNs() {
        return j();
    }

    public static /* synthetic */ e lambda$xdC4gxzJAa14bzrUEmJBqq371Pw() {
        return i();
    }

    public final c a(ComponentName r3, List<? extends AppEntity> r4) {
        List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "componentName");
        Intrinsics.checkNotNullParameter(r5, "newInAppEntities");
        return h().a(r3, r5);
    }

    public final void a() {
        g().b();
    }

    public final void a(List<? extends AppEntity> r3, List<? extends MetaValue> r4, List<? extends AppEntity> r5) {
        List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<? extends MetaValue> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<? extends AppEntity> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "inAppEntities");
        h().a(r6, r7, r8);
    }

    public final void b() {
        f().b();
    }

    public final void c() {
        h().b();
    }

    public final void d() {
        g().a();
        f().a();
        h().a();
    }

    public final void e() {
        a();
        b();
        c();
    }
}
