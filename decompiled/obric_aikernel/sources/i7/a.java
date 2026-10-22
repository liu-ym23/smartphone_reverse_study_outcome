package i7;

import android.content.Context;
import com.miui.bugreport.logprovider.DumpLogProvider;
import com.obric.aikernel.api.base.c;
import java.io.File;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c {

    /* JADX INFO: renamed from: i7.a$a, reason: collision with other inner class name */
    public static final class C0182a implements j6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9395a;

        C0182a(Context r10) {
            this.f9395a = r10;
        }

        @Override // j6.a
        public Map<String, File> a() {
            return MapsKt.mapOf(TuplesKt.to("aikernel_log", new File(this.f9395a.getFilesDir(), "logs")));
        }
    }

    public a() {
    }

    @Override // com.obric.aikernel.api.base.c
    public void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        DumpLogProvider.f(new C0182a(r10));
    }
}
