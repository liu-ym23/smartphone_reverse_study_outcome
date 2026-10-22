package com.mammon.speechlinklayersdk;

import com.mammon.speechaudiosdk.jni.structures.SpeechNativeProperty;
import com.mammon.speechlinklayersdk.jni.SpeechNativeLinkLayer;
import com.mammon.speechlinklayersdk.jni.callback.SpeechNativeLinkLayerCallback;
import com.mammon.speechlinklayersdk.param.SpeechHostInjectionDownlinkParam;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerCreateParam;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerUplinkCallbackParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechLinkLayer {
    public static final String TAG = " mammon SpeechLinkLayer";
    private final SpeechLinkLayerCreateParam linkLayerParam;
    private SpeechNativeLinkLayer nativeLinkLayer;

    public static class SpeechNativeLinkLayerCallbackImpl implements SpeechNativeLinkLayerCallback {
        private final SpeechLinkLayerCallback userCallback;

        public SpeechNativeLinkLayerCallbackImpl(SpeechLinkLayerCallback r1) {
            this.userCallback = r1;
        }

        @Override // com.mammon.speechlinklayersdk.jni.callback.SpeechNativeLinkLayerCallback
        public void onUplinkCallback(SpeechLinkLayerUplinkCallbackParam r2) {
            this.userCallback.onUplinkCallback(r2);
        }
    }

    public long getNativeHandle() {
        return this.nativeLinkLayer.getNativeHandle();
    }

    public int init() {
        SpeechNativeLinkLayerCallbackImpl r0 = new SpeechNativeLinkLayerCallbackImpl(this.linkLayerParam.linkLayerCallback);
        SpeechNativeLinkLayer r1 = new SpeechNativeLinkLayer();
        this.nativeLinkLayer = r1;
        r1.setEnableSyncInterface(true);
        this.nativeLinkLayer.setNativeLinkLayerCallback(r0);
        return this.nativeLinkLayer.createHandle(2, null);
    }

    public void release() {
        this.nativeLinkLayer.destroyHandle();
    }

    public SpeechLinkLayer(SpeechLinkLayerCreateParam r1) {
        this.linkLayerParam = r1;
    }

    public int processDownlinkData(SpeechHostInjectionDownlinkParam r3) {
        SpeechNativeProperty r0 = new SpeechNativeProperty();
        r0.id = 1002;
        r0.dataType = 101;
        r0.data = r3;
        return this.nativeLinkLayer.setProperty(r0);
    }
}
