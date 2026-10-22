package f2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final a b = null;
    public static final f c = null;
    public static final f d = null;
    public static final f e = null;
    public static final f f = null;
    public static final f g = null;
    public static final f h = null;
    public static final f i = null;
    public static final f j = null;
    public static final f k = null;
    public static final f l = null;
    public static final f m = null;
    public static final f n = null;
    public static final f o = null;
    public static final f p = null;
    public static final f q = null;
    public static final f r = null;
    public static final f s = null;
    public static final f t = null;
    public static final f u = null;
    public final String a;

    public static final class a {
        public a() {
        }

        public static f a() {
            return f.h;
        }

        public static f b() {
            return f.i;
        }

        public static f c() {
            return f.c;
        }

        public final f getType() {
            return f.r;
        }
    }

    static {
        b = new a();
        new f("call_id");
        c = new f("task_id");
        new f("session_id");
        new f("log_id");
        new f("style_id");
        new f("audio_scene");
        new f("session_category");
        new f("session_mode");
        new f("session_options");
        d = new f("result");
        e = new f("bot_id");
        f = new f("bot_name");
        g = new f("content_type");
        h = new f("conversation_id");
        i = new f("message_id");
        j = new f("voice_id");
        k = new f("text");
        l = new f("error_msg");
        m = new f("last_call_tts_task_id");
        n = new f("is_interrupt");
        o = new f("tts_subtitle_data");
        p = new f("sectionId");
        q = new f("queryRound");
        r = new f("type");
        s = new f("updateKey");
        t = new f("action");
        u = new f("enter_method");
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rawValue");
        this.a = r2;
    }

    public final boolean equals(Object r3) {
        String r1 = null;
        if ((r3 instanceof f) == false) goto L5;
        f r4 = (f) r3;
    L6:
        if (r4 == null) goto L9;
        r1 = r4.a;
    L9:
        return Intrinsics.areEqual(r1, this.a);
    L5:
        r4 = null;
        goto L6
    }
}
