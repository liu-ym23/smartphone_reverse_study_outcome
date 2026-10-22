package zp9;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface l extends t1a.a {

    public static final class a {
        public static /* synthetic */ void a(l r2, boolean r3, boolean r4, Long r5, boolean r6, boolean r7, int r8) {
            if ((r8 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r8 & 2) == 0) goto L9;
            r4 = false;
        L9:
            if ((r8 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r8 & 8) == 0) goto L15;
            r6 = false;
        L15:
            if ((r8 & 16) == 0) goto L17;
            r7 = false;
        L17:
            r2.L90(r3, r4, r5, r6, r7);
        }
    }

    void CO(UserCreation r1);

    void Eo(p r1);

    void L90(boolean r1, boolean r2, Long r3, boolean r4, boolean r5);

    void X20(Function0<? extends View> r1);

    void addOnScrollListener(RecyclerView.OnScrollListener r1);

    Integer computeVerticalScrollOffset();

    void deleteUserCreation(String r1, boolean r2);

    void fQ(UserCreation r1);

    RecyclerView getRecyclerView();

    void nh(f r1, e r2);

    LiveData<Boolean> og();

    void xc(UserCreation r1);
}
