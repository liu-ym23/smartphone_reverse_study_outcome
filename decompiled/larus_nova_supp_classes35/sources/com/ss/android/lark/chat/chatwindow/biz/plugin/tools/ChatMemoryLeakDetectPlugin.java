package com.ss.android.lark.chat.chatwindow.biz.plugin.tools;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatMemoryLeakDetectPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final /* synthetic */ int h = 0;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/plugin/tools/ChatMemoryLeakDetectPlugin$DetectViewModel;", "Landroidx/lifecycle/ViewModel;", "input", "Landroidx/lifecycle/LiveData;", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "<init>", "(Landroidx/lifecycle/LiveData;)V", "liveData", "Lcom/ss/android/lark/chat/chatwindow/biz/plugin/tools/DetectMemoryLiveData;", "getLiveData", "()Lcom/ss/android/lark/chat/chatwindow/biz/plugin/tools/DetectMemoryLiveData;", "observerCountFlow", "Lkotlinx/coroutines/flow/Flow;", BuildConfig.FLAVOR, "getObserverCountFlow", "()Lkotlinx/coroutines/flow/Flow;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DetectViewModel extends ViewModel {
        private final LiveData<i7b.a> input;
        private final DetectMemoryLiveData<i7b.a> liveData;
        private final Flow<Integer> observerCountFlow;

        public static final class a<T> implements Observer {
            public final /* synthetic */ DetectMemoryLiveData<i7b.a> a;

            public a(DetectMemoryLiveData<i7b.a> r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                DetectMemoryLiveData<i7b.a> r0 = this.a;
                r0.setValue((i7b.a) r2);
            }
        }

        public final DetectMemoryLiveData<i7b.a> getLiveData() {
            return this.liveData;
        }

        public final Flow<Integer> getObserverCountFlow() {
            return this.observerCountFlow;
        }

        public DetectViewModel(LiveData<i7b.a> r3) {
            this.input = r3;
            DetectMemoryLiveData<i7b.a> r0 = new DetectMemoryLiveData();
            if (r3 == null) goto L5;
            r0.addSource(r3, new a(r0));
        L5:
            this.liveData = r0;
            this.observerCountFlow = e.b(r0.a);
        }
    }

    public static final class a {
    }

    public static final class b implements ViewModelProvider.Factory {
        public final LiveData<i7b.a> a;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public b(MutableLiveData r1) {
            this.a = r1;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            return new DetectViewModel(this.a);
        }
    }

    public static final class c<T> implements Observer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((i7b.a) r2, "it");
            Log.d("ChatMemoryLeakDetect", "add init data observer");
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        throw null;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r9, i7b.a r10) {
        Intrinsics.checkNotNullParameter(r9, "chatApp");
        Intrinsics.checkNotNullParameter(r10, "initData");
        super.C(r9, r10);
        this.g = r9;
        Observer<? super i7b.a> r11 = c.a;
        DetectViewModel r0 = (DetectViewModel) new ViewModelProvider(r9.getFragment(), new b(r9.c().getInitData())).get(DetectViewModel.class);
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r9.getFragment());
        Fragment r1 = null;
        BuildersKt.launch$default(r2, null, null, new ChatMemoryLeakDetectPlugin$onCreate$1(r0, this, null), 3, null);
        Object r3 = r9.getHost();
        if ((r3 instanceof Fragment) == false) goto L5;
        r1 = (Fragment) r3;
    L5:
        if (r1 == null) goto L9;
        Lifecycle r4 = r1.getLifecycle();
        if (r4 == null) goto L9;
        r4.addObserver(new ChatMemoryLeakDetectPlugin$onCreate$2(this));
    L9:
        r0.getLiveData().observe(r9.getFragment(), r11);
    }
}
