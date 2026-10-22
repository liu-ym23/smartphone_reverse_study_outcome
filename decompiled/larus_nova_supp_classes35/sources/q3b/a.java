package q3b;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Content r2, Content r3) {
        Intrinsics.checkNotNullParameter(r2, "oldContent");
        Intrinsics.checkNotNullParameter(r3, "newContent");
        AudioContent r1 = null;
        if ((r2 instanceof AudioContent) == false) goto L5;
        AudioContent r4 = (AudioContent) r2;
    L6:
        if (r4 != null) goto L9;
        return;
    L9:
        if ((r3 instanceof AudioContent) == false) goto L11;
        r1 = (AudioContent) r3;
    L11:
        if (r1 != null) goto L14;
        return;
    L14:
        if (r4.isRecognizeFinished() == true) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L21;
        return;
    L21:
        if (r1.isRecognizeFinished() == true) goto L25;
        Log.i("AudioTextStableResultGuard", "keep finished audio text");
        r1.setRecognizedText(r4.getRecognizedText());
        r1.setRecognizedRichText(r4.getRecognizedRichText());
        r1.setRecognizeFinished(r4.isRecognizeFinished());
        r1.setAudio2TextStartTime(r4.getAudio2TextStartTime());
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r4.getRecognizedText()) == true) goto L18;
        r5 = true;
        goto L19
    L5:
        r4 = null;
        goto L6
    }
}
