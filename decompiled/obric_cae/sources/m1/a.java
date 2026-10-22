package m1;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.m;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9246b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f9247a;

    static {
        f9246b = m.f("SystemJobInfoConverter");
    }

    public a(Context r8) {
        this.f9247a = new ComponentName(r8.getApplicationContext(), SystemJobService.class);
    }
}
