package com.ss.android.lark.chat.service.impl.mediasend.depend;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.chat.service.impl.z0;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.rustinfrabridge.netstate.impl.d;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@ClaymoreImpl(oac.a.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/service/impl/mediasend/depend/VideoSendDependency;", "Lcom/ss/android/lark/videosend/bridge/IVideoSendDependency;", "<init>", "()V", "isFirstOpenAlbum", BuildConfig.FLAVOR, "onPreCompressMediaStart", BuildConfig.FLAVOR, "compressPath", BuildConfig.FLAVOR, "onPreCompressMediaMerged", "mgsId", "isWeakNet", "Companion", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSendDependency implements oac.a {
    private static final a Companion = null;
    private static final String TAG = "VideoSendDependency";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VideoSendDependency() {
    }

    public boolean isWeakNet() {
        List r0 = d.a;
        d.b.a.getClass();
        Object r1 = LarkNetworkLevelManager.d;
        NetworkLevelListener.NetworkLevel r2 = LarkNetworkLevelManager.a.a().getCurNetWorkLevel();
        Log.i(TAG, "curNetWorkLevel: " + r2);
        if (r2 != NetworkLevelListener.NetworkLevel.WEAK) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFirstOpenAlbum() {
        ImSdkProxy.d().isFirstOpenAlbum();
        return false;
    }

    public void onPreCompressMediaStart(String r1) {
        if (r1 != null) goto L4;
        r1 = BuildConfig.FLAVOR;
    L4:
        z0.g(r1);
    }

    public void onPreCompressMediaMerged(String r2, String r3) {
        if (r2 != null) goto L5;
        r2 = BuildConfig.FLAVOR;
    L5:
        if (r3 != null) goto L7;
        r3 = BuildConfig.FLAVOR;
    L7:
        z0.f(r2, r3);
    }
}
