package com.larus.bot.impl.feature.edit.feature.firstmet;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface l {

    public static final class a implements l {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements l {
        public b(Bundle r1) {
        }
    }

    public static final class c implements l {
        public final Lifecycle.Event a;

        public c(Lifecycle.Event r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a = r2;
        }
    }

    public static final class d implements l {
        public final PlayStateEnum a;

        public d(PlayStateEnum r1) {
            this.a = r1;
        }
    }

    public static final class e implements l {
        public final String a;

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            this.a = r2;
        }
    }

    public static final class f implements l {
        public final Boolean a;
        public final Triple<String, String, String> b;

        public f(Boolean r1, Triple<String, String, String> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements l {
        public final boolean a;

        public g() {
            this.a = true;
        }
    }

    public static final class h implements l {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }
    }
}
