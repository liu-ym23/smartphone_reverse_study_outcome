package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/media/MmPickedMedia;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmMediaPickResult$toLogString$mediaInfo$1 extends Lambda implements Function1<f, CharSequence> {
    public static final MmMediaPickResult$toLogString$mediaInfo$1 INSTANCE = null;

    static {
        INSTANCE = new MmMediaPickResult$toLogString$mediaInfo$1();
    }

    public MmMediaPickResult$toLogString$mediaInfo$1() {
        super(1);
    }

    public final CharSequence invoke(f r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.getClass();
        return "path=null, mimeType=null, isVideo=false, duration=0, width=0, height=0, size=0";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((f) r1);
    }
}
