package com.byted.cast.render.decoder;

import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class NativeVideoDecoder implements IMediaDecoder {
    private final CodecId codecId;
    private long ffmpegDecoder;
    private boolean isRunning;
    private IMediaDecoderListener listener;
    private MediaRenderState state;
    private final String userId;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private native void nativeSendPacket(long r1, byte[] r10, int r11, long r12);

    private native long nativeStart();

    private native boolean nativeStop(long r1);

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean stop() {
        this.isRunning = false;
        if (nativeStop(this.ffmpegDecoder) == false) goto L6;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        this.ffmpegDecoder = 0;
        return true;
    L6:
        return false;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean start() {
        INVOKESTATIC_com_byted_cast_render_decoder_NativeVideoDecoder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("MediaRenderJni");     // Catch: Exception -> L5
        this.ffmpegDecoder = nativeStart();
        this.state = MediaRenderState.STATE_EXECUTING;
        this.isRunning = true;
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public MediaRenderState getState() {
        return this.state;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_render_decoder_NativeVideoDecoder_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r10) {
        Intrinsics.checkNotNullParameter(r10, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r10);
        a.c(r10);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r10);
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public void setMediaDecoderListener(IMediaDecoderListener r1) {
        this.listener = r1;
    }

    public NativeVideoDecoder(String r10, CodecId r11) {
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        this.ffmpegDecoder = 0;
        this.isRunning = false;
        this.userId = r10;
        this.codecId = r11;
    }

    public void OnAVFrameAvailable(byte[] r10, long r11) {
        IMediaDecoderListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.OnAVFrameAvailable(r10, r11);
        return;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean sendPacket(byte[] r10, long r11) {
        if (this.isRunning == true) goto L6;
        return false;
    L6:
        long r1 = this.ffmpegDecoder;
        if (r1 == 0) goto L11;
        nativeSendPacket(r1, r10, r10.length, r11);
        return true;
    L11:
        return true;
    }

    public void OnVideoSizeChanged(int r10, int r11, int r12, int r13) {
        IMediaDecoderListener r0 = this.listener;
        if (r0 == null) goto L6;
        r0.OnVideoSizeChanged(r10, r11, r12, r11, r13);
        return;
    }
}
