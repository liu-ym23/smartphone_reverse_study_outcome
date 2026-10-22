package yr1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livesdk.chatroom.replay.input.ReplayEmojiInputDialogFragment;
import vr1.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface f {
    GradientEditText a(Context r1, int r2);

    CharSequence c(CharSequence r1, float r2);

    boolean d(CharSequence r1);

    View f(Context r1, boolean r2, int r3, lm1.e r4, c0 r5);

    View g(FragmentActivity r1, boolean r2, int r3, ReplayEmojiInputDialogFragment.b r4);

    Drawable getRealDrawable(String r1);

    int h(String r1, boolean r2, int r3);
}
