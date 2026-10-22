package vqb;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    void addFavoriteTab(com.ss.android.lark.maintab.export.a r1, IGetDataCallback<Unit> r2, boolean r3);

    void addVisitRecord(com.ss.android.lark.maintab.export.a r1);

    void deleteFavoriteTab(String r1, TabAppInfo.BizType r2, IGetDataCallback<Unit> r3);

    void deleteFavoriteTab(String r1, String r2, TabAppInfo.BizType r3, IGetDataCallback<Unit> r4);

    boolean enableFgMainTabContainer();

    void getAllTabs(IGetDataCallback<List<TabAppInfo>> r1);

    String getConversationTabKey();

    void isExistFavoriteTab(String r1, TabAppInfo.BizType r2, IGetDataCallback<Boolean> r3);

    void isExistFavoriteTab(String r1, String r2, TabAppInfo.BizType r3, IGetDataCallback<Boolean> r4);
}
