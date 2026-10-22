package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f1742a;

        public a() {
            this.f1742a = new d();
        }
    }

    public static class b {
        public ProviderInfo a(ResolveInfo r8) {
            throw null;
        }

        public Signature[] b(PackageManager r8, String r10) {
            throw null;
        }

        public List c(PackageManager r8, Intent r10) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    public static class C0013c extends b {
        @Override // androidx.emoji2.text.c.b
        public final ProviderInfo a(ResolveInfo r8) {
            return r8.providerInfo;
        }

        @Override // androidx.emoji2.text.c.b
        public final List c(PackageManager r8, Intent r10) {
            return r8.queryIntentContentProviders(r10, 0);
        }
    }

    public static class d extends C0013c {
        @Override // androidx.emoji2.text.c.b
        public final Signature[] b(PackageManager r8, String r10) {
            return r8.getPackageInfo(r10, 64).signatures;
        }
    }

    public static l a(Context r8) {
        a r10 = new a();
        PackageManager r11 = r8.getPackageManager();
        t2.b.n(r11, "Package manager required to locate emoji font provider");
        Intent r12 = new Intent("androidx.content.action.LOAD_EMOJI_FONT");
        b r13 = r10.f1742a;
        Iterator r14 = r13.c(r11, r12).iterator();
    L3:
        int r15 = 0;
        if (r14.hasNext() == false) goto L15;
        ProviderInfo r16 = r13.a((ResolveInfo) r14.next());
        if (r16 == null) goto L12;
        ApplicationInfo r17 = r16.applicationInfo;
        if (r17 == null) goto L12;
        boolean r18 = true;
        if ((r17.flags & 1) != 1) goto L12;
    L13:
        if (r18 == false) goto L3;
    L16:
        if (r16 != null) goto L30;
    L25:
        g0.f r19 = null;
    L26:
        if (r19 != null) goto L29;
        return null;
    L29:
        return new l(r8, r19);
    L30:
        String r20 = r16.authority;     // Catch: PackageManager.NameNotFoundException -> L23
        String r21 = r16.packageName;     // Catch: PackageManager.NameNotFoundException -> L23
        Signature[] r22 = r13.b(r11, r21);     // Catch: PackageManager.NameNotFoundException -> L23
        ArrayList r23 = new ArrayList();     // Catch: PackageManager.NameNotFoundException -> L23
        int r24 = r22.length;     // Catch: PackageManager.NameNotFoundException -> L23
    L19:
        if (r15 >= r24) goto L21;
        r23.add(r22[r15].toByteArray());     // Catch: PackageManager.NameNotFoundException -> L23
        r15 = r15 + 1;     // Catch: PackageManager.NameNotFoundException -> L23
        goto L19
    L21:
        r19 = new g0.f(r20, r21, "emojicompat-emoji-font", Collections.singletonList(r23));     // Catch: PackageManager.NameNotFoundException -> L23
    L23:
        e = move-exception;
        Log.wtf("emoji2.text.DefaultEmojiConfig", e);
    L12:
        r18 = false;
        goto L13
    L15:
        r16 = null;
        goto L16
    }
}
