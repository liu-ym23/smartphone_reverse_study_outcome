package com.ss.android.lark.keyboard.plugin.tool.at;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.at.a$a, reason: collision with other inner class name */
    public static final class C0154a {
        public static final /* synthetic */ int d = 0;
        public final List<b> a;
        public final List<UserGroupEntity> b;
        public final List<c> c;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.at.a$a$a, reason: collision with other inner class name */
        public static final class C0155a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0154a) == true) goto L8;
            return false;
        L8:
            C0154a r6 = (C0154a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "AtSelectorResult(chatterInfo=" + this.a + ", userGroupInfo=" + this.b + ", wikiInfo=" + this.c + ')';
        }

        public C0154a(List<b> r2, List<UserGroupEntity> r3, List<c> r4) {
            Intrinsics.checkNotNullParameter(r2, "chatterInfo");
            Intrinsics.checkNotNullParameter(r3, "userGroupInfo");
            Intrinsics.checkNotNullParameter(r4, "wikiInfo");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
        public final String a;
        public final Chatter.ChatterType b;
        public final String c;
        public final String d;
        public final boolean e;
        public final boolean f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Chatter.ChatterType r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            int r4 = 1231;
            if (this.e == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.f == true) goto L15;
            r4 = 1237;
        L15:
            return r6 + r4;
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ChatterInfo(chatterId=" + this.a + ", chatterType=" + this.b + ", displayName=" + this.c + ", originName=" + this.d + ", isOutChatUser=" + this.e + ", isAnonymous=" + this.f + ')';
        }

        public b(String r2, Chatter.ChatterType r3, String r4, String r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "chatterId");
            Intrinsics.checkNotNullParameter(r4, "displayName");
            Intrinsics.checkNotNullParameter(r5, "originName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class c {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "WikiInfo(url=null, title=null, localIconRes=null)";
        }
    }

    int a(String r1, boolean r2);

    void b(EditText r1, b r2);

    String c();

    boolean d(boolean r1, boolean r2);

    void e(boolean r1, com.ss.android.lark.keyboard.b r2, Bundle r3);

    AtomicBoolean f();

    C0154a g(Intent r1);

    void h(String r1);
}
