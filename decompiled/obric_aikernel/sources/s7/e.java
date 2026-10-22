package s7;

import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f12730b;

        a(String r10, Function0<Unit> r11) {
            this.f12729a = r10;
            this.f12730b = r11;
        }

        @Override // s7.f
        public void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            if (Intrinsics.areEqual(r10, this.f12729a) == false) goto L6;
            this.f12730b.invoke();
            return;
        }
    }

    public static final f a(String r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "settingsKey");
        Intrinsics.checkNotNullParameter(r11, "block");
        r11.invoke();
        a r12 = new a(r10, r11);
        AppSettingsManager.INSTANCE.registerObserver(r12);
        return r12;
    }
}
