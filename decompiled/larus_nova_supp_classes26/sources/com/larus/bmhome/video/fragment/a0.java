package com.larus.bmhome.video.fragment;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 {
    public static final a0 i = null;
    public boolean a;
    public int b;
    public String c;
    public String d;
    public String e;
    public VideoPlayView.a f;
    public Function2<? super String, ? super IVideoController, Unit> g;
    public boolean h;

    public static final class a {
        public final a0 a;

        public a() {
            this.a = new a0(0);
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            a0 r0 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.e = r3;
        }

        public final void b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            a0 r0 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.d = r3;
        }
    }

    public static final class b {
    }

    static {
        i = new a0(0);
    }

    public a0(int r3) {
        Intrinsics.checkNotNullParameter("default", "videoEngineKey");
        Intrinsics.checkNotNullParameter("", "videoEngineTag");
        Intrinsics.checkNotNullParameter("", "videoEngineSubTag");
        this.a = false;
        this.b = 0;
        this.c = "default";
        this.d = "";
        this.e = "";
        this.f = null;
        this.g = null;
        this.h = false;
    }
}
