package vr1;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.bytedance.android.live.core.widget.GradientEditText;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface g {
    GradientEditText a(Context r1, int r2);

    SpannableString c(CharSequence r1, float r2);

    View d(boolean r1, boolean r2, Function2 r3, Function0 r4, Function0 r5);

    com.bytedance.android.livesdk.chatroom.vs_host.impl.f f(boolean r1, boolean r2, Function2 r3, Function0 r4, Function0 r5, Function0 r6);

    List<Object> parseEmojiIndexList(CharSequence r1);
}
