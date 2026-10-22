package com.larus.platform.api.creation;

import android.net.Uri;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J!\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003H&¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/api/creation/IBachDetectCenterAbility;", "", "enableBachDetect", "", "detectAvatarUri", "", "uri", "Landroid/net/Uri;", "searchBachDetectResult", "remove", "(Landroid/net/Uri;Z)Ljava/lang/Boolean;", "cancelBachDetectTask", "redirectDetectUri", "oldUri", "newUri", "tryDetect", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IBachDetectCenterAbility {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J!\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001J \u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/api/creation/IBachDetectCenterAbility$Companion;", "Lcom/larus/platform/api/creation/IBachDetectCenterAbility;", "<init>", "()V", "cancelBachDetectTask", "", "uri", "Landroid/net/Uri;", "detectAvatarUri", "enableBachDetect", "", "redirectDetectUri", "oldUri", "newUri", "tryDetect", "searchBachDetectResult", "remove", "(Landroid/net/Uri;Z)Ljava/lang/Boolean;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IBachDetectCenterAbility {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IBachDetectCenterAbility b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final void a(Uri r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            this.b.a(r2);
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final boolean b() {
            return this.b.b();
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final Boolean c(Uri r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            return this.b.c(r2, r3);
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final void d(Uri r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            this.b.d(r2);
        }

        @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
        public final void e(Uri r2, Uri r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "oldUri");
            Intrinsics.checkNotNullParameter(r3, "newUri");
            this.b.e(r2, r3, r4);
        }

        private Companion() {
            IBachDetectCenterAbility r0 = (IBachDetectCenterAbility) ServiceManager.get().getService(IBachDetectCenterAbility.class);
            if (r0 != null) goto L5;
            r0 = new BachDetectCenterAbilityNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    void a(Uri r1);

    boolean b();

    Boolean c(Uri r1, boolean r2);

    void d(Uri r1);

    void e(Uri r1, Uri r2, boolean r3);
}
