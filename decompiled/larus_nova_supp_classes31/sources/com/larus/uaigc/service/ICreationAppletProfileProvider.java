package com.larus.uaigc.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/service/ICreationAppletProfileProvider;", "", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ICreationAppletProfileProvider {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/service/ICreationAppletProfileProvider$Companion;", "Lcom/larus/uaigc/service/ICreationAppletProfileProvider;", "<init>", "()V", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements ICreationAppletProfileProvider {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICreationAppletProfileProvider b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.service.ICreationAppletProfileProvider
        public final Fragment a(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "bundle");
            return this.b.a(r2);
        }

        private Companion() {
            ICreationAppletProfileProvider r0 = (ICreationAppletProfileProvider) ServiceManager.get().getService(ICreationAppletProfileProvider.class);
            if (r0 != null) goto L5;
            r0 = new ICreationAppletProfileProviderNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    Fragment a(Bundle r1);
}
