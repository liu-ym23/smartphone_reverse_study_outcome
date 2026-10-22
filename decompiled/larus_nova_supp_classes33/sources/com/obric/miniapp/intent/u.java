package com.obric.miniapp.intent;

import com.obric.capabilitykit.entity.app.MusicEntity;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class u {
    public static final u a = null;

    public static final class a {
        public final String a;
        public final MusicEntity[] b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + Arrays.hashCode(this.b);
        }

        public final String toString() {
            return "ReceivedMusicCard(cardId=" + this.a + ", songs=" + Arrays.toString(this.b) + ')';
        }

        public a(String r2, MusicEntity[] r3) {
            Intrinsics.checkNotNullParameter(r2, "cardId");
            Intrinsics.checkNotNullParameter(r3, "songs");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new u();
    }

    public u() {
    }

    public static JSONObject a(JSONObject r2) {
        Object r3 = r2.opt("widget_data");
        if ((r3 instanceof JSONObject) == true) goto L20;
        Object r1 = null;
        if ((r3 instanceof String) == false) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(new JSONObject((String) r3));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == true) goto L21;
        r1 = r4;
    L21:
        return (JSONObject) r1;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return (JSONObject) r3;
    }
}
