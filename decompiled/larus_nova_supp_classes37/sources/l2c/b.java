package l2c;

import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.ss.android.lark.reaction.loader.reaction.ReactionResource;
import java.io.InputStream;
import rkb.d;
import rkb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements d<ReactionResource, InputStream> {

    public static class a implements e<ReactionResource, InputStream> {
        public a() {
        }

        public final void teardown() {
        }

        public final d<ReactionResource, InputStream> build(MultiModelLoaderFactory r1) {
            return new b();
        }
    }

    public b() {
    }

    public final rkb.a getResourceFetcher(Object r1, int r2, int r3) {
        return new l2c.a(((ReactionResource) r1).reactionKey);
    }
}
