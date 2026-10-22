package iib;

import android.content.Context;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a extends IModel {
    void L1(boolean r1, List r2, UIGetDataCallback r3);

    void L6(Context r1, List<ForwardTarget> r2, IGetDataCallback<com.ss.android.lark.forwardv2.impl.model.b> r3);

    void Y4(SearchBaseInfo r1, boolean r2);

    void a3();

    String getSource();

    CallbackManager m3();

    List<SearchBaseInfo> z7();
}
