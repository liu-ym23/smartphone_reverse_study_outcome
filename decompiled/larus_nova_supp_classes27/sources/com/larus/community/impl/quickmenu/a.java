package com.larus.community.impl.quickmenu;

import android.net.Uri;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import o29.i;
import o29.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larus.community.impl.quickmenu.a$a, reason: collision with other inner class name */
    public static final class C0021a {
        public final i a;

        public C0021a() {
            this.a = new i();
        }

        public static void a(C0021a r13, String r14, String r15, String r16, Uri r17, Uri r18, boolean r110, boolean r20, int r21) {
            String r5 = null;
            if ((r21 & 4) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r21 & 16) == 0) goto L9;
            Uri r6 = null;
        L11:
            if ((r21 & 32) != 0) goto L14;
            r5 = "creation_dosame_quick_menu";
        L14:
            String r7 = r5;
            boolean r8 = false;
            if ((r21 & 64) == 0) goto L17;
            boolean r9 = false;
        L19:
            if ((r21 & 128) != 0) goto L22;
            r8 = r20;
        L22:
            r13.getClass();
            Intrinsics.checkNotNullParameter(r14, "id");
            Intrinsics.checkNotNullParameter(r15, "title");
            Intrinsics.checkNotNullParameter(r17, "iconUri");
            i r12 = r13.a;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r14, "id");
            Intrinsics.checkNotNullParameter(r15, "title");
            Intrinsics.checkNotNullParameter(r17, "iconUri");
            ((ArrayList) r12.a).add(new j(r14, r15, r3, r17, r6, r7, r9, r8, null));
            return;
        L17:
            r9 = r110;
            goto L19
        L9:
            r6 = r18;
            goto L11
        L5:
            r3 = r16;
            goto L7
        }
    }

    static {
    }
}
