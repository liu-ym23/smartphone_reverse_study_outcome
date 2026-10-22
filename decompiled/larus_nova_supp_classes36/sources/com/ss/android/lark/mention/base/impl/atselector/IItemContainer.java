package com.ss.android.lark.mention.base.impl.atselector;

import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IItemContainer {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectMode {
        public static final int MULTI = 1;
        public static final int SINGLE = 0;
    }

    public interface a {
        void a(BaseAtBean r1);

        void b(BaseAtBean r1);

        void c(BaseAtBean r1);
    }

    a a0();

    int getItemCount();

    List<BaseAtBean> getItems();

    int y0();
}
