package gnb;

import android.view.View;
import com.ss.android.lark.export.b;
import com.ss.android.lark.export.c;
import com.ss.android.lark.export.d;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.url.card.extension.UrlCardEngineFactory;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements zcb.a {
    public final ConcurrentHashMap<Type, c<? extends e<? extends Props, ? extends View, ? extends r6c.a>>> a;
    public final ConcurrentHashMap<EngineProperty.EngineType, d<? extends e<? extends Props, ? extends View, ? extends r6c.a>>> b;
    public final ConcurrentHashMap<ModelParserRenderRouterEntity.CardEngineType, com.ss.android.lark.export.a<? extends e<? extends Props, ? extends View, ? extends r6c.a>>> c;
    public final ConcurrentHashMap<String, b> d;

    public a() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public final boolean a(com.ss.android.lark.url.card.extension.a.b r3) {
        Intrinsics.checkNotNullParameter("universal_card_cache_key", TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "engineCache");
        if (this.d.get("universal_card_cache_key") != null) goto L6;
        this.d.put("universal_card_cache_key", r3);
        return true;
    L6:
        return false;
    }

    public final void b(UrlCardEngineFactory r3) {
        Intrinsics.checkNotNullParameter(r3, "cardEngineComponentFactory");
        ModelParserRenderRouterEntity.CardEngineType r0 = ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD;
        this.c.put(r0, r3);
    }
}
