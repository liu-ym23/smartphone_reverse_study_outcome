package com.larus.bmhome.chat.cotdetail;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/ICotDetailService;", "", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "arguments", "Landroid/os/Bundle;", "getCurrentThreadId", "", "dismiss", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface ICotDetailService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/ICotDetailService$Companion;", "Lcom/larus/bmhome/chat/cotdetail/ICotDetailService;", "<init>", "()V", "dismiss", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getCurrentThreadId", "", "show", "", "arguments", "Landroid/os/Bundle;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Companion implements ICotDetailService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ ICotDetailService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bmhome.chat.cotdetail.ICotDetailService
        public final void a(FragmentManager r2) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
            this.b.a(r2);
        }

        @Override // com.larus.bmhome.chat.cotdetail.ICotDetailService
        public final boolean b(FragmentManager r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
            Intrinsics.checkNotNullParameter(r3, "arguments");
            return this.b.b(r2, r3);
        }

        @Override // com.larus.bmhome.chat.cotdetail.ICotDetailService
        public final String c(FragmentManager r2) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
            return this.b.c(r2);
        }

        private Companion() {
            this.b = (ICotDetailService) ServiceManager.get().getService(ICotDetailService.class);
        }
    }

    static {
        a = Companion.c;
    }

    void a(FragmentManager r1);

    boolean b(FragmentManager r1, Bundle r2);

    String c(FragmentManager r1);
}
