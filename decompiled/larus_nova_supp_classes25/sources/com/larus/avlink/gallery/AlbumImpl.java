package com.larus.avlink.gallery;

import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.avlink.api.IAlbumService;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.view.MineAlbumFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.s;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.x0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/gallery/AlbumImpl;", "Lcom/larus/avlink/api/IAlbumService;", "<init>", "()V", "weakAlbumFragmentReference", "Ljava/lang/ref/WeakReference;", "Lcom/larus/platform/api/IMineAlbumFragment;", "albumFragment", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "albumEnable", "", "getCurrentAlbumFragment", "hasCompletedMedia", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AlbumImpl implements IAlbumService {
    public static final a b = null;
    public WeakReference<x0> a;

    public static final class a {
        public a() {
        }
    }

    public AlbumImpl() {
    }

    static {
        b = new a();
    }

    public final Fragment a() {
        MineAlbumFragment r0 = new MineAlbumFragment();
        this.a = new WeakReference(r0);
        return r0;
    }

    public final x0 b() {
        WeakReference<x0> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final boolean c() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r1 = false;
        if (r0 == null) goto L7;
        s r2 = r0.s0();
        if (r2 == null) goto L7;
        boolean r3 = Intrinsics.areEqual(r2.E(), Boolean.TRUE);
    L9:
        if (r3 == true) goto L19;
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L15;
        s r5 = r4.s0();
        if (r5 == null) goto L15;
        boolean r6 = Intrinsics.areEqual(r5.D(), Boolean.TRUE);
    L16:
        if (r6 == true) goto L19;
        boolean r7 = false;
    L20:
        b.getClass();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L23
        Object r9 = Result.constructor-impl(Boolean.valueOf(Keva.getRepo("dora_kv_env", 0).getBoolean("key_dataset_inject_enabled", false)));     // Catch: Throwable -> L23
    L25:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L28;
        r9 = r10;
    L28:
        boolean r11 = ((Boolean) r9).booleanValue();
        if (r7 == true) goto L31;
        if (r11 == true) goto L31;
    L32:
        FLogger.a.i("AlbumImpl", "hasDoraE device: " + r7 + ", injectEnabled: " + r11 + ", enable: " + r1);
        return r1;
    L31:
        r1 = true;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        r6 = false;
    L19:
        r7 = true;
    L7:
        r3 = false;
        goto L9
    }

    public final Object d(Continuation<? super Boolean> r6) {
        if ((r6 instanceof AlbumImpl$hasCompletedMedia$1) == false) goto L7;
        AlbumImpl$hasCompletedMedia$1 r0 = (AlbumImpl$hasCompletedMedia$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L13
    L21:
        List r8 = (List) r7;     // Catch: Exception -> L13
        if ((r8 instanceof Collection) == true) goto L24;
    L26:
        Iterator r9 = r8.iterator();     // Catch: Exception -> L13
    L27:
        if (r9.hasNext() == false) goto L37;
        if (((MediaMetadata) r9.next()).getLifecycleState() != MediaLifecycleState.COMPLETED) goto L32;
        boolean r5 = true;
    L33:
        if (r5 == false) goto L27;
        r4 = true;
        goto L37
    L32:
        r5 = false;
    L37:
        return Boxing.boxBoolean(r4);
    L24:
        if (r8.isEmpty() == false) goto L26;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r7);
        AlbumDataBaseHelper r10 = AlbumDataBaseHelper.a;     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r7 = r10.m(r0);     // Catch: Exception -> L13
        if (r7 != r2) goto L21;
        return r2;
    L13:
        e = move-exception;
        FLogger.a.e("AlbumImpl", "check has completed media exception", e);
    L7:
        r0 = new AlbumImpl$hasCompletedMedia$1(this, r6);
        goto L8
    }
}
