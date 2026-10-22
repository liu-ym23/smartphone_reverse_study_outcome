package qb0;

import com.bytedance.android.live.ktv.common.midi.g;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ Pair a(b r6, float r7, float r8, float r9, boolean r11, boolean r12, int r13) {
            if ((r13 & 4) == 0) goto L5;
            float r3 = 0.0f;
        L7:
            if ((r13 & 8) == 0) goto L9;
            boolean r4 = false;
        L11:
            if ((r13 & 16) == 0) goto L13;
            boolean r5 = false;
        L15:
            return r6.l1(r7, r8, r3, r4, r5);
        L13:
            r5 = r12;
            goto L15
        L9:
            r4 = r11;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }
    }

    void D3(long r1);

    void D5(int r1, int r2);

    void J3(long r1);

    void S3();

    void clear();

    void detach();

    void f0(db0.a r1, g r2);

    void hide();

    Pair<Float, Float> l1(float r1, float r2, float r3, boolean r4, boolean r5);

    void setScoreInterval(long r1);

    void show();

    void y(MidiSkinDressInfo r1);
}
