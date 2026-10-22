package com.obric.oui.sheet.v2;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J&\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "", "fling", "", "xVelocity", "", "yVelocity", "move", "dx", "dy", CommonConsts.APM_INNER_EVENT_COST_START, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface d {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(d r2, float r3, float r4, boolean r5, int r6, Object r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L16;
            if ((r6 & 1) == 0) goto L8;
            r3 = 0.0f;
        L8:
            if ((r6 & 2) == 0) goto L11;
            r4 = 0.0f;
        L11:
            if ((r6 & 4) == 0) goto L13;
            r5 = false;
        L13:
            r8.a(r3, r4, r5);
            return;
        L16:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: move");
        }
    }

    void a(float r1, float r2);

    void a(float r1, float r2, boolean r3);
}
