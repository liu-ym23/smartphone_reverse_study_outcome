package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import v0.e;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements d1.b<a> {

    public static class a {
    }

    public ProfileInstallerInitializer() {
    }

    @Override // d1.b
    public final List<Class<? extends d1.b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // d1.b
    public final a b(Context r8) {
        final Context r10 = r8.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new e(this, r10));
        return new a();
    }
}
