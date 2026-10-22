package p0c;

import android.os.Bundle;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static Bundle a(String r3, String r4, String r5, String r6, String r7, String r8) {
        Log.i("PhotoEditorLauncher", "startPhotoEditor: " + ("imagePath=" + r3 + ",resultPath=" + r4 + ",from=" + r5 + ",showSaveBtn=true,showForwardBtn=false,fileKey=" + r6 + ",chatId=" + r7 + ",messageId=" + r8 + ",presetMaskRects=-1"));
        Bundle r0 = new Bundle();
        r0.putString("key_image_url", r3);
        r0.putString("key_result_path", r4);
        r0.putString("key_from", r5);
        r0.putBoolean("key_show_save_btn", true);
        r0.putBoolean("key_show_forward_btn", false);
        r0.putString("key_file_key", r6);
        r0.putString("chat_id", r7);
        r0.putString("message_id", r8);
        if (CollectionUtils.isEmpty(null) == true) goto L5;
        r0.putParcelableArrayList("key_preset_mask_rects", new ArrayList(null));
    L5:
        return r0;
    }
}
