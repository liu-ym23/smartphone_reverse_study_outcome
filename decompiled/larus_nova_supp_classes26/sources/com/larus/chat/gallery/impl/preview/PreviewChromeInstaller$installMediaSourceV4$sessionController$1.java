package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.platform.model.preview.AttachmentEditType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PreviewChromeInstaller$installMediaSourceV4$sessionController$1 extends FunctionReferenceImpl implements Function0<AttachmentEditType> {
    public PreviewChromeInstaller$installMediaSourceV4$sessionController$1(Object r8) {
        super(0, r8, PreviewCameraParamProvider.class, "consumePendingEditType", "consumePendingEditType()Lcom/larus/platform/model/preview/AttachmentEditType;", 0);
    }

    public final AttachmentEditType invoke() {
        PreviewCameraParamProvider r0 = (PreviewCameraParamProvider) ((CallableReference) this).receiver;
        AttachmentEditType r1 = r0.m;
        r0.m = AttachmentEditType.MARK;
        return r1;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m120invoke() {
        return invoke();
    }
}
