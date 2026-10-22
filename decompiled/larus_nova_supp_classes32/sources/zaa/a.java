package zaa;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.obric.assistant.activation.presentation.contract.ipc.VoiceInteractionSessionController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a {
    void a(int r1, int r2, boolean r3, AssistStructure r4, AssistContent r5);

    void b(long r1, VoiceInteractionSessionController r3);

    void c(Bitmap r1);

    void d(Bundle r1, int r2);

    void e(long r1);
}
