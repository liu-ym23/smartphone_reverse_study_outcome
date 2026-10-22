package com.obric.assistant.storage;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/storage/ObricLowStorageServiceDelegate;", "Lcom/obric/assistant/storage/IObricLowStorageService;", "<init>", "()V", "checkAndBlockIfLowStorage", "", "activity", "Landroid/app/Activity;", "checkAndBlockIfLowStorageGlobal", "init", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLowStorageServiceDelegate implements IObricLowStorageService {
    public static final ObricLowStorageServiceDelegate b = null;
    public final /* synthetic */ IObricLowStorageService a;

    static {
        b = new ObricLowStorageServiceDelegate();
    }

    public final boolean a() {
        return this.a.a();
    }

    public final void init() {
        this.a.init();
    }

    private ObricLowStorageServiceDelegate() {
        this.a = (IObricLowStorageService) ServiceManager.get().getService(IObricLowStorageService.class);
    }
}
