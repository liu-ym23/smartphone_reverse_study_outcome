package com.obric.oui.picker.reels.a;

import android.content.Context;
import android.util.AttributeSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J+\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/OReelPickerBuilder;", "FT", "DT", "", "build", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)Ljava/lang/Object;", "setOnChangedListener", "", "listener", "Ljava/util/function/Consumer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface b<FT, DT> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(b r2, Context r3, AttributeSet r4, int r5, int r6, Object r7) {
            b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 2) == 0) goto L8;
            r10 = null;
        L8:
            if ((r6 & 4) == 0) goto L11;
            r5 = 0;
        L11:
            return r8.b(r9, r10, r5);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
        }
    }

    FT b(Context r1, AttributeSet r2, int r3);
}
