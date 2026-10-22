package b7b;

import android.content.Context;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements IMRichTextCopyUtils.a {
    public final /* synthetic */ Context a;

    @Override // com.ss.android.lark.chat.utils.IMRichTextCopyUtils.a
    public final void onSuccess() {
        UDToast.show(this.a, 2131891640);
    }

    public a(Context r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.utils.IMRichTextCopyUtils.a
    public final void onError(Exception r4) {
        if ((r4 instanceof SensitiveAPIException) == false) goto L5;
        UDToast.show(this.a, 2131891032);
        return;
    L5:
        Log.e("ChatMessageUtils", "Copy failed", r4, true);
    }
}
