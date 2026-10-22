package y48;

import com.larus.asr.config.builder.ChatSpeakerElementKey;
import com.larus.asr.config.builder.ChatSpeakerScene;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final /* synthetic */ int h = 0;
    public ChatSpeakerScene a;
    public z48.a b;
    public d c;
    public Map<ChatSpeakerElementKey, i> d;
    public boolean e;
    public boolean f;
    public boolean g;

    public static final class a {
        public static f a() {
            f r0 = new f();
            r0.a = ChatSpeakerScene.Default;
            r0.b = null;
            r0.c = d.e;
            int r1 = p.b;
            r0.d = MapsKt.toMutableMap(p.a.a().a);
            r0.e = false;
            r0.f = false;
            r0.g = false;
            return r0;
        }
    }

    static {
    }

    public final v a() {
        return new v(this.a, this.b, this.c, new p(MapsKt.toMap(this.d)));
    }

    public f() {
        this.a = ChatSpeakerScene.Default;
        this.c = d.e;
        int r0 = p.b;
        this.d = MapsKt.toMutableMap(p.a.a().a);
    }

    public final void b(x48.b r4) {
        if (this.e == true) goto L9;
        if (r4 == null) goto L6;
        z48.a r0 = r4.a;
    L7:
        this.b = r0;
        goto L9
    L6:
        r0 = null;
    L9:
        if (this.f == false) goto L11;
        return;
    L11:
        if (this.g == true) goto L21;
        d r1 = this.c;
        if (r4 == null) goto L17;
        boolean r2 = true;
        if (r4.b != true) goto L17;
    L18:
        this.c = d.a(r1, r2, false, false, 14);
        return;
    L17:
        r2 = false;
        goto L18
    }
}
