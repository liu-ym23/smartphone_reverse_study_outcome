package teb;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final boolean g = false;
    public FeedListAdapter a;
    public volatile RecyclerView b;
    public RecyclerView.Recycler c;
    public ArrayList<RecyclerView.ViewHolder> d;
    public HashMap<String, Pair<Long, RecyclerView.ViewHolder>> e;
    public final a f;

    public class a implements Runnable {
        public final /* synthetic */ d a;

        public final void a() {
            if (this.a.b.getScrollState() == 0) goto L5;
            return;
        L5:
            d r0 = this.a;
            if (r0.c == null) goto L8;
            int r1 = r0.b.getChildCount();
            View r2 = this.a.b.getChildAt(0);
            View r3 = this.a.b.getChildAt(r1 - 1);
            HashSet r5 = new HashSet();
            int r4 = this.a.b.getChildAdapterPosition(r2);
            int r6 = this.a.b.getChildAdapterPosition(r3);
            int r7 = 1;
        L13:
            if (r7 > 8) goto L22;
            int r8 = r4 - r7;
            if (r8 < 0) goto L17;
            r5.add(Integer.valueOf(r8));
        L17:
            int r9 = r6 + r7;
            if (r9 > (this.a.a.getItemCount() - 1)) goto L20;
            r5.add(Integer.valueOf(r9));
        L20:
            r7 = r7 + 1;
            goto L13
        L22:
            if (d.g == false) goto L25;
            Log.d("FeedPreBinder", "================================");
            Log.d("FeedPreBinder", "firstChildAdapterPosition=" + r4);
            Log.d("FeedPreBinder", "lastChildAdapterPosition=" + r6);
            Log.d("FeedPreBinder", "tempSet=" + r5);
        L25:
            if (this.a.d == null) goto L34;
            int r10 = 0;
        L28:
            if (r10 >= this.a.d.size()) goto L34;
            RecyclerView.ViewHolder r11 = (RecyclerView.ViewHolder) ListProtector.get(this.a.d, r10);
            int r12 = r11.getAdapterPosition();
            r5.remove(Integer.valueOf(r12));
            if (d.g == false) goto L32;
            Log.e("FeedPreBinder", "cachedView index=" + r10 + " adapterPosition= " + r12 + " holder=" + r11);
        L32:
            r10 = r10 + 1;
        L34:
            if (d.g == false) goto L36;
            Log.d("FeedPreBinder", "tempSet without cachedView=" + r5);
            Log.d("FeedPreBinder", "================================");
        L36:
            HashMap<String, Pair<Long, RecyclerView.ViewHolder>> r13 = new HashMap();
            Iterator r14 = r5.iterator();
        L38:
            if (r14.hasNext() == false) goto L47;
            Integer r15 = (Integer) r14.next();
            UIFeedCard r16 = (UIFeedCard) this.a.a.getItem(r15.intValue());
            String r17 = r16.getId();
            long r18 = r16.getUpdateTime();
            Pair<Long, RecyclerView.ViewHolder> r19 = this.a.e.remove(r17);
            if (r19 == null) goto L38;
            if (((Long) r19.first).longValue() != r18) goto L38;
            r13.put(r17, r19);
            if (d.g == false) goto L38;
            Log.d("FeedPreBinder", "put into newExtentCachedView: use already prebinded position=" + r15 + " id=" + r17 + " updateTime=" + r18 + " holder=" + r19.second);
            goto L38
        L47:
            Iterator<Pair<Long, RecyclerView.ViewHolder>> r20 = this.a.e.values().iterator();
        L49:
            if (r20.hasNext() == false) goto L51;
            this.a.b.getRecycledViewPool().putRecycledView((RecyclerView.ViewHolder) r20.next().second);
            goto L49
        L51:
            this.a.e.clear();
            Iterator r21 = r5.iterator();
        L53:
            if (r21.hasNext() == false) goto L80;
            Integer r22 = (Integer) r21.next();
            UIFeedCard r23 = (UIFeedCard) this.a.a.getItem(r22.intValue());
            String r24 = r23.getId();
            long r110 = r23.getUpdateTime();
            if (r13.containsKey(r24) == true) goto L53;
            int r25 = this.a.a.getItemViewType(r22.intValue());
            RecyclerView.ViewHolder r111 = this.a.b.getRecycledViewPool().getRecycledView(r25);
            if (r111 != null) goto L60;
            d r112 = this.a;
            r111 = r112.a.createViewHolder(r112.b, r25);
        L60:
            d r26 = this.a;
            r26.getClass();
            ViewGroup.LayoutParams r113 = r111.itemView.getLayoutParams();
            if (r113 != null) goto L64;
            ViewGroup.LayoutParams r27 = r26.b.getLayoutManager().generateDefaultLayoutParams();
            r111.itemView.setLayoutParams(r27);
        L82:
            d27.b.c(r27, "mViewHolder", r111);     // Catch: IllegalAccessException -> L74
        L76:
            this.a.c.bindViewToPosition(r111.itemView, r22.intValue());
            r13.put(r24, new Pair(Long.valueOf(r110), r111));
            if (d.g == false) goto L53;
            Log.d("FeedPreBinder", "put into newExtentCachedView: prebinded  position=" + r22 + " id=" + r24 + " updateTime=" + r110 + " holder=" + r111);
        L74:
            e = move-exception;
            Log.e("FeedPreBinder", "fixLayoutParams: set rvLayoutParams.mViewHolder error", e);
            goto L76
        L64:
            if ((r113 instanceof RecyclerView.LayoutParams) == true) goto L66;
        L68:
            boolean r28 = false;
        L69:
            if (r28 == true) goto L71;
            r27 = r26.b.getLayoutManager().generateLayoutParams(r113);
            r111.itemView.setLayoutParams(r27);
            goto L82
        L71:
            r27 = (RecyclerView.LayoutParams) r113;
            goto L82
        L66:
            if (r26.b.getLayoutManager().checkLayoutParams((RecyclerView.LayoutParams) r113) == false) goto L68;
            r28 = true;
            goto L69
        L80:
            this.a.e = r13;
            return;
        L8:
            if (d.g == false) goto L101;
            Log.e("FeedPreBinder", "recycler is null.");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r1) {
            this.a = r1;
        }
    }

    static {
        g = DevEnvUtil.isDevelopPackage(LarkContext.getApplication());
    }

    public d() {
        this.c = null;
        this.d = null;
        this.e = new HashMap();
        this.f = new a(this);
    }
}
