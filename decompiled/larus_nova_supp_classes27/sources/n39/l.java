package n39;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface l {

    public static final class a {
        public static /* synthetic */ void a(l r2) {
            r2.leaveStreamEditMode(0, true);
        }
    }

    void addSelectedTextChangeListener(Function3<? super String, ? super String, ? super String, Unit> r1);

    void clearReference();

    void endStreamEdit(boolean r1);

    void enterStreamEditIfNeeded();

    void enterStreamEditMode(Function1<? super String, Unit> r1);

    String getRefBlockInfo();

    Pair<String, String> getSelectedText();

    void handleActionBarPaste();

    void leaveStreamEditMode(int r1, boolean r2);

    void notifyTrackInfoUpdated();

    void removeSelectedTextChangeListener(Function3<? super String, ? super String, ? super String, Unit> r1);

    void resetAiEditState();

    boolean shouldShowBackSegment();

    void startStreamEdit();

    void streamEditTextContent(String r1);
}
