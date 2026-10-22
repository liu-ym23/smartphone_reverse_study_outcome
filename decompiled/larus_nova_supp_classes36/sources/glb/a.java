package glb;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.monitor.perf.BasePerfMonitor;
import com.ss.android.lark.utils.ImageUtils;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BasePerfMonitor.b {
    public String a;
    public Biz b;
    public Scene c;
    public boolean d;
    public int e;
    public boolean f;
    public String g;
    public long h;
    public int i;
    public int j;
    public long k;
    public int l;
    public int m;
    public int n;
    public boolean o;

    /* JADX INFO: renamed from: glb.a$a, reason: collision with other inner class name */
    public static final class C0269a {
    }

    static {
    }

    @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
    public final String getEventName(int r1) {
        return "gallery_load";
    }

    public a() {
        this.a = "";
        this.b = Biz.Messenger;
        this.c = Scene.Chat;
        this.d = true;
        this.e = 5;
        this.f = true;
        this.g = ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
        this.h = -1;
        this.k = -1;
    }

    @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.b
    public final void end() {
        super.end();
        AppreciableKit.Companion r0 = AppreciableKit.Companion;
        r0.getInstance().spanEnd(this.a, "data_load_cost");
        AppreciableKit.end$default(r0.getInstance(), this.a, null, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_content_length", Long.valueOf(this.h)), TuplesKt.to("resource_width", Integer.valueOf(this.i)), TuplesKt.to("resource_height", Integer.valueOf(this.j)), TuplesKt.to("upload_content_length", Long.valueOf(this.k)), TuplesKt.to("upload_width", Integer.valueOf(this.l)), TuplesKt.to("upload_height", Integer.valueOf(this.m)), TuplesKt.to("compress_cost", Integer.valueOf(this.n))}), MapsKt.mapOf(new Pair[]{TuplesKt.to("from_type", Integer.valueOf(this.e)), TuplesKt.to("is_encrypt", Boolean.valueOf(this.d)), TuplesKt.to("media_is_origin_type", Boolean.valueOf(this.f)), TuplesKt.to("image_type", this.g)}), 6, null);
        this.a = "";
    }

    public final void a(Biz r9, Scene r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "biz");
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r12, "page");
        super.start();
        this.b = r9;
        this.c = r10;
        this.e = r11;
        AppreciableKit.Companion r13 = AppreciableKit.Companion;
        this.a = AppreciableKit.start$default(r13.getInstance(), this.b, this.c, Event.image_upload, r12, false, 16, null);
        r13.getInstance().spanStart(this.a, "data_load_cost");
    }
}
