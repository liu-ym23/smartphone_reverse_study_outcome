package wp9;

import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements lp9.b {
    public static final d a = null;
    public static final Lazy b = null;

    public d() {
    }

    static {
        a = new d();
        b = LazyKt.lazy(new c());
    }

    public static kq9.a c() {
        return (kq9.a) b.getValue();
    }

    @Override // lp9.b
    public final boolean e() {
        FLogger.a.i("AlbumFastInputConfigManager", "isAttachmentLeftCameraEnabled enableAttachmentLeftCamera=" + c().a());
        return c().a();
    }

    @Override // lp9.b
    public final boolean a() {
        if (c().b() == false) goto L5;
    L8:
        return true;
    L5:
        if (c().c() == true) goto L8;
        return false;
    }

    @Override // lp9.b
    public final boolean b(String r4, Integer r5) {
        FLogger.a.i("AlbumFastInputConfigManager", "isUgcBotInputEnabled conversationId=" + r4 + " botConversationType=" + r5 + " enableUgcBotInput=" + c().c());
        if (com.larus.bmhome.utils.i.e(r4, r5) == false) goto L7;
        return false;
    L7:
        return c().c();
    }

    @Override // lp9.b
    public final boolean d(String r4, Integer r5) {
        FLogger.a.i("AlbumFastInputConfigManager", "isMainBotInputEnabled conversationId=" + r4 + " botConversationType=" + r5 + " enableMainBotInput=" + c().b());
        if (com.larus.bmhome.utils.i.e(r4, r5) == true) goto L7;
        return false;
    L7:
        return c().b();
    }
}
