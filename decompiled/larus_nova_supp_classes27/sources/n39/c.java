package n39;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c extends com.larus.office.base.service.a<c> {

    public static final class a {
        public static /* synthetic */ void a(c r1, String r2, boolean r3, boolean r4, int r5) {
            if ((r5 & 4) == 0) goto L5;
            r4 = false;
        L5:
            r1.setChatInputVisible(r2, r3, r4, false);
        }
    }

    boolean consumeToAiEdit();

    Object getAppIconUrl(Continuation<? super String> r1);

    int getChatInputHeight();

    void getLatestMessageId(Function1<? super String, Unit> r1);

    i1<Boolean> getVoiceInputStatus();

    boolean isChatInputVisible();

    boolean isEnableVoiceInput();

    void notifyInitChatInput(ViewGroup r1, FragmentManager r2);

    void onDocDeleted();

    void onDocNeedUpdate();

    void onDocStateChanged(boolean r1);

    void onLoadFinishEventReported();

    void requestChatInputFocus();

    void selectCurrentSentenceOrParagraph();

    void setChatInputVisibility(boolean r1);

    void setChatInputVisible(String r1, boolean r2, boolean r3, boolean r4);

    void setEnableVoiceInput(boolean r1, String r2);

    void setToAiEdit();
}
