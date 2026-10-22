package a5;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f98a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f99b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f100c;
    public String d;
    public String e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f104k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f105l;

    public final List a() {
        List r5 = this.f104k;
        if (r5 == null) goto L7;
        if (r5.isEmpty() == true) goto L7;
    L11:
        return this.f104k;
    L7:
        if (TextUtils.equals(this.f99b, "https://mon-va.byteoversea.com") == false) goto L9;
        this.f104k = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uaXNuc3Nkay5jb20vbW9uaXRvci9hcHBtb25pdG9yL3YyL3NldHRpbmdz", 0)));
        goto L11
    L9:
        this.f104k = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uc25zc2RrLmNvbS9tb25pdG9yL2FwcG1vbml0b3IvdjIvc2V0dGluZ3M=", 0)));
        goto L11
    }

    public final List b() {
        List r5 = this.f105l;
        if (r5 == null) goto L7;
        if (r5.isEmpty() == true) goto L7;
    L11:
        return this.f105l;
    L7:
        if (TextUtils.equals(this.f99b, "https://mon-va.byteoversea.com") == false) goto L9;
        this.f105l = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uaXNuc3Nkay5jb20vbW9uaXRvci9jb2xsZWN0Lw==", 0)));
        goto L11
    L9:
        this.f105l = Collections.singletonList(new String(Base64.decode("aHR0cHM6Ly9tb24uc25zc2RrLmNvbS9tb25pdG9yL2NvbGxlY3Qv", 0)));
        goto L11
    }
}
