package com.larus.bmhome.chat.picture;

import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import li8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/larus/bmhome/chat/picture/LocalTakePictureImpl$registerResultForPhotoEdit$1", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LocalTakePictureImpl$registerResultForPhotoEdit$1 extends SafeLifecycleObserver {
    public final /* synthetic */ LocalTakePictureImpl a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ Function4<String, String, Boolean, Boolean, Unit> c;
    public final /* synthetic */ Function1<Intent, Unit> d;

    public final void onCreate(LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r7, "owner");
        LocalTakePictureImpl r8 = this.a;
        Fragment r0 = this.b;
        ActivityResultContracts.StartActivityForResult r1 = new ActivityResultContracts.StartActivityForResult();
        final LocalTakePictureImpl r2 = this.a;
        final Function4<String, String, Boolean, Boolean, Unit> r3 = this.c;
        final Function1<Intent, Unit> r4 = this.d;
        r8.b = r0.registerForActivityResult(r1, new o(r2, r3, r4));
        FLogger.a.i("TakePictureService", "editPhotoLauncher:" + this.a.b);
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.a.b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalTakePictureImpl$registerResultForPhotoEdit$1(LocalTakePictureImpl r1, Fragment r2, Function4<? super String, ? super String, ? super Boolean, ? super Boolean, Unit> r3, Function1<? super Intent, Unit> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
