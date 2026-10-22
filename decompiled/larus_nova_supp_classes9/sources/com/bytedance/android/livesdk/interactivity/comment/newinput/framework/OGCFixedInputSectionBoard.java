package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.interactivity.api.input.viewpager.InputSectionBoard;
import com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014R\"\u0010\u000e\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/OGCFixedInputSectionBoard;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/InputSectionBoard;", BuildConfig.FLAVOR, "colorStr", BuildConfig.FLAVOR, "setTitleColor", BuildConfig.FLAVOR, "getLayoutId", "f", "Ljava/lang/String;", "getTitleColorStr", "()Ljava/lang/String;", "setTitleColorStr", "(Ljava/lang/String;)V", "titleColorStr", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedInputSectionBoard extends InputSectionBoard {
    public String f;

    public OGCFixedInputSectionBoard(Context r4) {
        this(r4, null, 0, 14);
    }

    public OGCFixedInputSectionBoard(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public OGCFixedInputSectionBoard(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.InputSectionBoard
    public int getLayoutId() {
        return 2131567059;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.InputSectionBoard
    public final SelectionListAdapter b() {
        return new OGCFixedInputSelectionListAdapter(this.f, getSelectionRecycleView(), getSelections());
    }

    public final String getTitleColorStr() {
        return this.f;
    }

    public void setTitleColor(String r1) {
        if (r1 == null) goto L5;
        this.f = r1;
        return;
    }

    public final void setTitleColorStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public OGCFixedInputSectionBoard(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        this.f = "#161823";
    }
}
