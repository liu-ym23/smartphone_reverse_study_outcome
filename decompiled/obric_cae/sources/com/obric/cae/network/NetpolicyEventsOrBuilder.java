package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface NetpolicyEventsOrBuilder extends MessageOrBuilder {
    AppNetOpChangedEvent getAppNetOpChangedEvents(int r8);

    int getAppNetOpChangedEventsCount();

    List<AppNetOpChangedEvent> getAppNetOpChangedEventsList();

    AppNetOpChangedEventOrBuilder getAppNetOpChangedEventsOrBuilder(int r8);

    List<? extends AppNetOpChangedEventOrBuilder> getAppNetOpChangedEventsOrBuilderList();

    BlockedReasonChangedEvent getBlockedReasonChangedEvents(int r8);

    int getBlockedReasonChangedEventsCount();

    List<BlockedReasonChangedEvent> getBlockedReasonChangedEventsList();

    BlockedReasonChangedEventOrBuilder getBlockedReasonChangedEventsOrBuilder(int r8);

    List<? extends BlockedReasonChangedEventOrBuilder> getBlockedReasonChangedEventsOrBuilderList();

    MeteredIfacesChangedEvent getMeteredIfacesChangedEvents(int r8);

    int getMeteredIfacesChangedEventsCount();

    List<MeteredIfacesChangedEvent> getMeteredIfacesChangedEventsList();

    MeteredIfacesChangedEventOrBuilder getMeteredIfacesChangedEventsOrBuilder(int r8);

    List<? extends MeteredIfacesChangedEventOrBuilder> getMeteredIfacesChangedEventsOrBuilderList();

    PowerStateEvent getPowerStateEvents(int r8);

    int getPowerStateEventsCount();

    List<PowerStateEvent> getPowerStateEventsList();

    PowerStateEventOrBuilder getPowerStateEventsOrBuilder(int r8);

    List<? extends PowerStateEventOrBuilder> getPowerStateEventsOrBuilderList();

    RestrictBackgroundChangedEvent getRestrictBackgroundChangedEvents(int r8);

    int getRestrictBackgroundChangedEventsCount();

    List<RestrictBackgroundChangedEvent> getRestrictBackgroundChangedEventsList();

    RestrictBackgroundChangedEventOrBuilder getRestrictBackgroundChangedEventsOrBuilder(int r8);

    List<? extends RestrictBackgroundChangedEventOrBuilder> getRestrictBackgroundChangedEventsOrBuilderList();

    SleepModeChangedEvent getSleepModeChangedEvents(int r8);

    int getSleepModeChangedEventsCount();

    List<SleepModeChangedEvent> getSleepModeChangedEventsList();

    SleepModeChangedEventOrBuilder getSleepModeChangedEventsOrBuilder(int r8);

    List<? extends SleepModeChangedEventOrBuilder> getSleepModeChangedEventsOrBuilderList();

    SubscriptionOverrideChangedEvent getSubscriptionOverrideChangedEvents(int r8);

    int getSubscriptionOverrideChangedEventsCount();

    List<SubscriptionOverrideChangedEvent> getSubscriptionOverrideChangedEventsList();

    SubscriptionOverrideChangedEventOrBuilder getSubscriptionOverrideChangedEventsOrBuilder(int r8);

    List<? extends SubscriptionOverrideChangedEventOrBuilder> getSubscriptionOverrideChangedEventsOrBuilderList();

    SubscriptionPlansChangedEvent getSubscriptionPlansChangedEvents(int r8);

    int getSubscriptionPlansChangedEventsCount();

    List<SubscriptionPlansChangedEvent> getSubscriptionPlansChangedEventsList();

    SubscriptionPlansChangedEventOrBuilder getSubscriptionPlansChangedEventsOrBuilder(int r8);

    List<? extends SubscriptionPlansChangedEventOrBuilder> getSubscriptionPlansChangedEventsOrBuilderList();

    UidPoliciesChangedEvent getUidPoliciesChangedEvents(int r8);

    int getUidPoliciesChangedEventsCount();

    List<UidPoliciesChangedEvent> getUidPoliciesChangedEventsList();

    UidPoliciesChangedEventOrBuilder getUidPoliciesChangedEventsOrBuilder(int r8);

    List<? extends UidPoliciesChangedEventOrBuilder> getUidPoliciesChangedEventsOrBuilderList();

    UidRulesChangedEvent getUidRulesChangedEvents(int r8);

    int getUidRulesChangedEventsCount();

    List<UidRulesChangedEvent> getUidRulesChangedEventsList();

    UidRulesChangedEventOrBuilder getUidRulesChangedEventsOrBuilder(int r8);

    List<? extends UidRulesChangedEventOrBuilder> getUidRulesChangedEventsOrBuilderList();
}
