package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.ContextThemeWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {
        private final Context mContext;
        private LayoutInflater mDropDownInflater;
        private final LayoutInflater mInflater;

        public Helper(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
            this.mInflater = LayoutInflater.from(r4);
        }

        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater r0 = this.mDropDownInflater;
            if (r0 == null) goto L6;
            return r0;
        L6:
            return this.mInflater;
        }

        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater r2 = this.mDropDownInflater;
            if (r2 != null) goto L6;
            return null;
        L6:
            return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme();
        }

        public void setDropDownViewTheme(Resources.Theme r3) {
            if (r3 != null) goto L6;
            LayoutInflater r4 = null;
        L4:
            this.mDropDownInflater = r4;
            return;
        L6:
            if (r3.equals(this.mContext.getTheme()) == false) goto L8;
            r4 = this.mInflater;
            goto L4
        L8:
            r4 = LayoutInflater.from(new ContextThemeWrapper(this.mContext, r3));
            goto L4
        }
    }

    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme r1);
}
